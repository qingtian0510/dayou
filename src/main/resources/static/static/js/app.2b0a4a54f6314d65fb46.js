webpackJsonp([1],{"4q4r":function(e,t){},Di81:function(e,t){},NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=n("7+uW"),r={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var a=n("VU/8")({name:"App"},r,!1,function(e){n("4q4r")},null,null).exports,i=n("/ocq"),s={render:function(){var e=this.$createElement;return(this._self._c||e)("div",[this._v("\n  Hello World!\n")])},staticRenderFns:[]};var l=n("VU/8")({name:"AppIndex"},s,!1,function(e){n("OZ0f")},"data-v-24f0bc46",null).exports,u={name:"Login",data:function(){return{loginForm:{username:"admin",password:"123"},responseResult:[]}},methods:{login:function(){var e=this,t=this;console.log(this.$store.state),console.log("hahahahahhah"),this.$axios.post("/login",{username:this.loginForm.username,password:this.loginForm.password}).then(function(n){if(200===n.data.code){t.$store.commit("login",t.loginForm);var o=e.$route.query.redirect;e.$router.replace({path:"/"===o||void 0===o?"/index":o})}}).catch(function(e){})}}},c={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("body",{attrs:{id:"poster"}},[n("el-form",{staticClass:"login-container",attrs:{"label-position":"left","label-width":"0px"}},[n("h3",{staticClass:"login_title"},[e._v("系统登录")]),e._v(" "),n("el-form-item",[n("el-input",{attrs:{type:"text","auto-complete":"off",placeholder:"账号"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),e._v(" "),n("el-form-item",[n("el-input",{attrs:{type:"password","auto-complete":"off",placeholder:"密码"},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}})],1),e._v(" "),n("el-form-item",{staticStyle:{width:"100%"}},[n("el-button",{staticStyle:{width:"100%",background:"#505458",border:"none"},attrs:{type:"primary"},on:{click:e.login}},[e._v("登录")])],1)],1)],1)},staticRenderFns:[]};var p=n("VU/8")(u,c,!1,function(e){n("Di81")},null,null).exports;o.default.use(i.a);var d=new i.a({mode:"history",routes:[{path:"/login",name:"Login",component:p},{path:"/index",name:"AppIndex",component:l,meta:{requireAuth:!0}}]}),m=n("mvHQ"),f=n.n(m),h=n("LvQi");o.default.use(h.a);var g=new h.a.Store({state:{user:{username:null==window.localStorage.getItem("user")?"":JSON.parse(window.localStorage.getItem("user")).username}},mutations:{login:function(e,t){e.user=t,window.localStorage.setItem("user",f()(t))}}}),v=n("zL8q"),w=n.n(v),_=(n("tvR6"),n("mtWM"));_.defaults.baseURL="http://localhost:8443/api",o.default.prototype.$axios=_,o.default.config.productionTip=!1,o.default.use(w.a),d.beforeEach(function(e,t,n){e.meta.requireAuth?g.state.user.username?n():n({path:"login",query:{redirect:e.fullPath}}):n()}),new o.default({el:"#app",render:function(e){return e(a)},router:d,store:g,components:{App:a},template:"<App/>"})},OZ0f:function(e,t){},tvR6:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.2b0a4a54f6314d65fb46.js.map