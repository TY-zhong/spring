<template>
    <div class="album-out clearfix">
        <div class="album-item fl">
            <div class="cover-item">
                <svg class="icon add-icon" aria-hidden="true">
                    <use xlink:href="#icon-xiangce1"></use>
                </svg>
                <div>新建相册</div>
            </div>
        </div>
        <div class="album-item fl" v-for="album in albumList" :key="album.id">
            <div class="cover-item">
                <img v-if="album.coverUrl !== null" :src="album.coverUrl"/>
                <svg v-else class="icon" aria-hidden="true">
                    <use xlink:href="#icon-xiangce"></use>
                </svg>
            </div>
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
        this.$post('/album/list', {pageNum: 1, pageSize: 20}).then(data => {
            this.albumList = this.albumList.concat(data.list)
        })
    }
}
</script>

<style lang="scss" scoped>
.album-out{
    >.album-item{
        margin-top: 20px;
        width: 169px;
        height: 216px;
        display: inline-block;
        text-align: center;
        margin-left: 12.5px;
        >.cover-item{
            width: 169px;
            height: 169px;
            background: #eee;
            border-radius: 5px;
            >.add-icon{
                font-size: 56px;
                margin-top: 54px;
                color: #999;
            }
        }
    }
}
</style>
