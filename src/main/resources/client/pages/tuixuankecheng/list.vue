<template>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view :style='{"width":"100%","padding":"0 0 0 0","position":"relative","background":"#ffffff","height":"100%"}'>
			<view :style='{"minHeight":"100rpx","width":"100%","position":"relative","alignItems":"center","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"backgroundColor":"#f5f5f5","margin":"0 30rpx 0 30rpx","color":"#333333","alignItems":"center","borderRadius":"0px","flex":"1","display":"flex","lineHeight":"64rpx","fontSize":"24rpx","height":"64rpx"}'>
					<text class="iconfont icon-sousuo1" :style='{"margin":"0 16rpx 0 16rpx"}'></text>
					<input v-model="searchForm.kechengmingcheng" type="text" placeholder="课程名称" :style='{"background":"transparent","height":"100%"}'></input>
				</view>
				<button @tap="search" :style='{"border":"0px","padding":"0 40rpx 0 40rpx","margin":"0 20rpx 0 0px","borderRadius":"0px","background":"#f0f0f0","fontSize":"28rpx","lineHeight":"64rpx","height":"64rpx"}'>搜索</button>
			</view>
			<view :style='{"width":"100%","flexWrap":"wrap","background":"#ffffff","justifyContent":"space-between","display":"flex","height":"auto"}'>

			
			<!-- 样式1 -->
			<view class="uni-product-list" :style='{"padding":"24rpx 24rpx 24rpx 24rpx","margin":"40rpx 0 0 0","alignItems":"flex-start","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
				<view @tap="onDetailTap(product)" class="uni-product" :style='{"boxShadow":"0 6rpx 12rpx #eeeeee","margin":"0 0 40rpx 0","backgroundColor":"#ffffff","borderRadius":"8rpx","flexWrap":"wrap","textAlign":"center","display":"flex","width":"48%","justifyContent":"center","height":"auto"}' v-for="(product,index) in list" :key="index">
					<view class="uni-product-title" :style='{"padding":"0px 20rpx 0px 20rpx","margin":"0 0 0px 0","whiteSpace":"nowrap","color":"#333333","textAlign":"left","overflow":"hidden","borderRadius":"8rpx","width":"100%","lineHeight":"72rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"2","height":"72rpx"}'>课程名称:{{product.kechengmingcheng}}</view>
					<view class="uni-product-title" :style='{"padding":"0px 20rpx 0px 20rpx","margin":"0 0 0px 0","whiteSpace":"nowrap","color":"#333333","textAlign":"left","overflow":"hidden","borderRadius":"8rpx","width":"100%","lineHeight":"72rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"2","height":"72rpx"}'>上课时间:{{product.shangkeshijian}}</view>
					<view class="uni-product-title" :style='{"padding":"0px 20rpx 0px 20rpx","margin":"0 0 0px 0","whiteSpace":"nowrap","color":"#333333","textAlign":"left","overflow":"hidden","borderRadius":"8rpx","width":"100%","lineHeight":"72rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"2","height":"72rpx"}'>取消时间:{{product.quxiaoshijian}}</view>
					<view :style='{"padding":"0","margin":"8rpx 0 0 0","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"3"}'>
						<view :style='{"border":"0px solid #dcf8f5","padding":"0px 20rpx 20rpx 20rpx","borderRadius":"60rpx","display":"flex"}' v-if="(userid && isAuth('tuixuankecheng','修改')) || (!userid && isAuthFront('tuixuankecheng','修改'))" @click.stop="onUpdateTap(product.id)">
							<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#1D5DCA","display":"inline-block"}' class="iconfont icon-xiugai2"></text>
							<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#1D5DCA","display":"inline-block"}'>修改</text>
						</view>
						<view :style='{"border":"0px solid #f9dede","padding":"0px 20rpx 20rpx 20rpx","borderRadius":"60rpx","display":"flex"}' v-if="(userid && isAuth('tuixuankecheng','删除')) || (!userid && isAuthFront('tuixuankecheng','删除'))" @click.stop="onDeleteTap(product.id)">
							<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#cc0000","display":"inline-block"}' class="iconfont icon-shanchu4"></text>
							<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#cc0000","display":"inline-block"}'>删除</text>
						</view>
					</view>
				</view>
			</view>
			
			
			
			

			</view>
			
			
			
		</view>
		<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx #cccccc","color":"#333333","bottom":"120rpx","right":"120rpx","outline":"none","borderRadius":"100%","background":"#75ebde","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('tuixuankecheng','新增')" class="add-btn" @click="onAddTap()">新增</button>
		<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx #cccccc","color":"#333333","bottom":"120rpx","right":"120rpx","outline":"none","borderRadius":"100%","background":"#75ebde","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('tuixuankecheng','新增')" class="add-btn" @click="onAddTap()">新增</button>
	</view>
</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{},
				CustomBar: '0',
				screenBoxShow:false
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(()=> {
                                return (0.5-Math.random());
                        });
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		async onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		methods: {
			
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//查询条件切换
			queryChange(e) {
				this.queryIndex=e.detail.value;
				this.searchForm.kechengmingcheng="";
			},
			//类别搜索
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size
				}


				if(this.searchForm.kechengmingcheng){
					params['kechengmingcheng'] = '%' + this.searchForm.kechengmingcheng + '%'
				}



                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`tuixuankecheng`, params);
                } else {
                    res = await this.$api.list(`tuixuankecheng`, params);
                }
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			// 修改
			onUpdateTap(id){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('tuixuankecheng', JSON.stringify([id]));
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.mescroll.resetUpScroll()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size
				}
				if(this.searchForm.kechengmingcheng){
					searchForm['kechengmingcheng'] = '%' + this.searchForm.kechengmingcheng + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`tuixuankecheng`, searchForm);
                } else {
                    res = await this.$api.list(`tuixuankecheng`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
				this.screenBoxShow = false
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.category-one .tab {
		cursor: pointer;
		padding: 0 20rpx 0 20rpx;
		color: #333333;
		background: #ffffff;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 80rpx;
		height: 80rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		padding: 0 20rpx 0 20rpx;
		color: #ffffff;
		background: #1D5DCA;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 80rpx;
	}
	
	.category-two .tab {
		cursor: pointer;
		padding: 0 0 0 0;
		margin: 0 0 24rpx;
		color: #333;
		background: url(http://chy2.gdnxeco.com/20230914/9a307f891d964f0cb446d562b4d23d72.png) no-repeat right center,#06988830;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
		height: 80rpx;
	}
	
	.category-two .tab.active {
		cursor: pointer;
		padding: 0 0 0 0;
		margin: 0 0 24rpx;
		color: #fff;
		background: url(http://chy2.gdnxeco.com/20230914/9a307f891d964f0cb446d562b4d23d72.png) no-repeat right center,#069888;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-three .tab {
		cursor: pointer;
		padding: 0 20rpx;
		margin: 0 0 24rpx;
		color: #333;
		background: #06988830;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
		height: 80rpx;
	}
	
	.category-three .tab.active {
		cursor: pointer;
		padding: 0 20rpx;
		margin: 0 0 24rpx;
		color: #fff;
		background: #069888;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	.screenBoxBG {
		position: fixed;
		width: 100%;
		height: 100%;
		z-index: 665;
		top: 0;
		left: 0;
		background: rgba(0, 0, 0, .3);
	}
	
	.screenBox {
		width: 80%;
		position: fixed;
		height: 100%;
		right: 0;
		top: 0;
		z-index: 666;
		-webkit-transform: translate3d(100%, 0, 0);
		transform: translate3d(100%, 0, 0);
		transition: transform .3s;
		overflow-y: scroll;
		.screenTab{
			border-radius: 40rpx;
			margin: 10rpx 0 10rpx 0;
			color: #666666;
			background: #ffffff;
			width: calc(100% / 3 - 24rpx);
			line-height: 72rpx;
			text-align: center;
		}
		.screenTabActive{
			border-radius: 40rpx;
			margin: 10rpx 0 10rpx 0;
			color: #333333;
			background: #75ebde;
			width: calc(100% / 3 - 20rpx);
			line-height: 72rpx;
			text-align: center;
		}
	}
	
	.screenBoxActive {
		-webkit-transform: translate3d(0%, 0, 0);
		transform: translate3d(0%, 0, 0);
	}
</style>
