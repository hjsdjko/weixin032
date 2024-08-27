<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"120rpx 44rpx 244rpx 44rpx","background":"url(http://clfile.zggen.cn/20231027/1c74fe0f859b421da2ff00db828f3937.jpg) no-repeat center top / 100%,#6185fd","height":"100%"}'>
		<view :style='{"padding":"40rpx 48rpx 40rpx 48rpx","boxShadow":"0px 0px 0px #dddddd","margin":"0 0 244rpx 0","borderRadius":"24rpx","background":"#ffffff","display":"block","width":"100%","position":"relative","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 40rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"160rpx"}' src="http://clfile.zggen.cn/20231027/f76234bafa534579beeb9a486c2d2df2.jpg" mode="aspectFill"></image>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.xuehao" type="text" class="uni-input" name="" placeholder="学号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.mima" type="password" class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.xingming" type="text" class="uni-input" name="" placeholder="姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" @tap="xueshengtouxiangTap" class="">
                <view>请上传头像</view>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","objectFit":"contain","display":"block","height":"160rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","objectFit":"contain","display":"block","height":"160rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<picker :style='{"border":"2rpx solid #eeeeee","width":"100%","padding":"0 20rpx","margin":"0 0 24rpx 0","borderRadius":"40rpx","height":"auto"}' v-if="tableName=='xuesheng'"  @change="xueshengxingbieChange" :value="xueshengxingbieIndex" :range="xueshengxingbieOptions">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666666"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.lianxidianhua" type="text" class="uni-input" name="" placeholder="联系电话" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.zhuanye" type="text" class="uni-input" name="" placeholder="专业" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.banji" type="text" class="uni-input" name="" placeholder="班级" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.xuexiao" type="text" class="uni-input" name="" placeholder="学校" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.jiaoshigonghao" type="text" class="uni-input" name="" placeholder="教师工号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.jiaoshimima" type="password" class="uni-input" name="" placeholder="教师密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.jiaoshimima2" type="password" class="uni-input" name="" placeholder="确认教师密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.jiaoshixingming" type="text" class="uni-input" name="" placeholder="教师姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" @tap="jiaoshitouxiangTap" class="">
                <view>请上传头像</view>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","objectFit":"contain","display":"block","height":"160rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","objectFit":"contain","display":"block","height":"160rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<picker :style='{"border":"2rpx solid #eeeeee","width":"100%","padding":"0 20rpx","margin":"0 0 24rpx 0","borderRadius":"40rpx","height":"auto"}' v-if="tableName=='jiaoshi'"  @change="jiaoshixingbieChange" :value="jiaoshixingbieIndex" :range="jiaoshixingbieOptions">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666666"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"40rpx","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.lianxidianhua" type="text" class="uni-input" name="" placeholder="联系电话" />
			</view>
			<button :style='{"border":"0","padding":"0 0 0 0","margin":"0 0 24rpx 0","color":"#ffffff","borderRadius":"60rpx","background":"url(http://clfile.zggen.cn/20231027/6e8b0d771019408d8e99fb9a88018f81.png) no-repeat center top / 100%","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","height":"80rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                xueshengxingbieOptions: [],
                xueshengxingbieIndex: 0,
                jiaoshixingbieOptions: [],
                jiaoshixingbieIndex: 0,
				ruleForm: {
                xuehao: '',
                mima: '',
                xingming: '',
                touxiang: '',
                xingbie: '',
                lianxidianhua: '',
                zhuanye: '',
                banji: '',
                xuexiao: '',
                jiaoshigonghao: '',
                jiaoshimima: '',
                jiaoshixingming: '',
                touxiang: '',
                xingbie: '',
                lianxidianhua: '',
                jianjie: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

			// 自定义下拉框值
			if(this.tableName=='xuesheng'){
                this.xueshengxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.xueshengxingbieOptions[0]
			}
			// 自定义下拉框值
			if(this.tableName=='jiaoshi'){
                this.jiaoshixingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.jiaoshixingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            xueshengtouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'file/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            xueshengxingbieChange(e) {
                    this.xueshengxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.xueshengxingbieOptions[this.xueshengxingbieIndex]
            },
            jiaoshitouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'file/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            jiaoshixingbieChange(e) {
                    this.jiaoshixingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.jiaoshixingbieOptions[this.jiaoshixingbieIndex]
            },
            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					document.querySelectorAll('.radioText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#666666","display":"inline-block"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.radioTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#1d5dca","display":"inline-block"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.checkText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#666666"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.checkTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#1d5dca"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #eeeeee","outlineColor":"#666666","background":"#ffffff","display":"inline-block"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #1d5dca","textAlign":"center","background":"#1d5dca","display":"inline-block"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #eeeeee","borderColor":"#666666","borderRadius":"40rpx","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"borderColor":"#1d5dca","color":"#ffffff","borderRadius":"40rpx","background":"#1d5dca"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				if((!this.ruleForm.xuehao) && `xuesheng` == this.tableName){
					this.$utils.msg(`学号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `xuesheng` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`xuesheng` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.xingming) && `xuesheng` == this.tableName){
					this.$utils.msg(`姓名不能为空`);
					return
				}
				if(`xuesheng` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if((!this.ruleForm.jiaoshigonghao) && `jiaoshi` == this.tableName){
					this.$utils.msg(`教师工号不能为空`);
					return
				}
				if((!this.ruleForm.jiaoshimima) && `jiaoshi` == this.tableName){
					this.$utils.msg(`教师密码不能为空`);
					return
				}
                if(`jiaoshi` == this.tableName && (this.ruleForm.jiaoshimima!=this.ruleForm.jiaoshimima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.jiaoshixingming) && `jiaoshi` == this.tableName){
					this.$utils.msg(`教师姓名不能为空`);
					return
				}
				if(`jiaoshi` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
