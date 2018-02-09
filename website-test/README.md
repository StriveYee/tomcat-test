这是一个最原始的SpringMVC+Velocity的架构案例
1、spring mvc里面已经包含了一个context，因此不需要再重新初始化一个context，在web.xml里面可以看到
2、servlet执行步骤是lisenter-->filter-->controller，由于spring intercepter的加入，可以看出执行顺序为
lisenter-->filter-->intercepter-->controller
执行步骤
(1) 启动
== Lisenter     ==(servlet context initialized)-->spring context initialized

== Filter       ==(filter init)

(2) 发起会话
== Lisenter     ==(request lisenter initialized)

== Filter       ==(do filter)

== Intercepter  ==(prehandle)

== Lisenter     ==(session created，html controller中代码有显示调用getSession或者jsp页面默认打开session)

== Controller   ==(页面渲染之前的业务逻辑代码)

== Intercepter  ==(posthandle 这里可以拿到ModelAndView)

render(页面渲染)

== Intercepter  ==(afterComletion)

== Filter       ==(chain.dofilter 之后的代码)

== Lisenter     ==(request destroyed)

