<template>
    <div>
        <div>新建相册</div>
        <div v-for="album in albumList" :key="album.id">
            <img :src="album.coverUrl"/>
            <div>{{album.name}}</div>
            <div>{{album.photoNum + '张'}}</div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'album-list',
    data () {
        return {
            albumList: []
        }
    },
    mounted () {
        console.log(1)
        this.$post('album/list', {}, response => {
            console.log(response)
        });
    }
}
</script>

<style lang="scss" scoped>
</style>
