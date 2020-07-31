<template>
    <div class="photo-out">
        <img :src="photo.url" v-for="photo in photoList" :key="photo.id"/>
        <input type="file" @change="fileChange"/>
        <button @click="upload">上传</button>
    </div>
</template>

<script>
import * as qiniu from 'qiniu-js'
export default {
    name: 'photo-list',
    data () {
        return {
            photoList: [],
            albumId: this.$route.query.albumId,
            file: null
        }
    },
    mounted () {
        this.listByAlbumId(this.albumId)
    },
    methods: {
        listByAlbumId (albumId) {
            this.$post('/photo/listByAlbumId', {albumId: albumId, pageNum: 1, pageSize: 30}, false).then(data => {
                this.photoList = this.photoList.concat(data.list)
            })
        },
        fileChange(event) {
            this.file = event.target.files[0]
        },
        upload () {
            let fileDom = document.getElementsByTagName('input')
            let file = fileDom[0].files[0]
            const observer = {
                next(res){
                    console.log(res)
                },
                error(err){
                    console.log(err)
                },
                complete(res){
                    console.log(res)
                }
            }
            this.$post('/photo/getQiNiuToken', {}).then(data => {
                const observable = qiniu.upload(file, "123.txt", data, null, null)
                observable.subscribe(observer) // 上传开始
            })
        }
    }
}
</script>

<style lang="scss" scoped>
.photo-out{
    padding: 10px;
    >img{}
}
</style>
