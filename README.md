### Architecture

```
 ::Client LoadBanancer::
                          
 ┌───────────────────────┐      ┌───────────────────────┐
 │ client         (8080) │  ──> │ server-1       (8081) │
 └───────────────────────┘  │   └───────────────────────┘
                            │   ┌───────────────────────┐
                            └─> │ server-2       (8082) │
                                └───────────────────────┘
```

### Log

```text
2018-04-11 22:35:28.625  INFO 20681 --- [           main] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client stores initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=stores,current list of Servers=[localhost:8081, localhost:8082],Load balancer stats=Zone stats: {unknown=[Zone:unknown;	Instance count:2;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
},Server stats: [[Server:localhost:8081;	Zone:UNKNOWN;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 09:00:00 KST 1970;	First connection made: Thu Jan 01 09:00:00 KST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
, [Server:localhost:8082;	Zone:UNKNOWN;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 09:00:00 KST 1970;	First connection made: Thu Jan 01 09:00:00 KST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
]}ServerList:com.netflix.loadbalancer.ConfigurationBasedServerList@6ab4ba9f
2018-04-11 22:35:28.746  INFO 20681 --- [           main] c.h.SpringCloudRibbonClientApplication   : ::: server 1 :::
2018-04-11 22:35:28.751  INFO 20681 --- [           main] c.h.SpringCloudRibbonClientApplication   : ::: server 2 :::
2018-04-11 22:35:28.755  INFO 20681 --- [           main] c.h.SpringCloudRibbonClientApplication   : ::: server 1 :::
2018-04-11 22:35:28.760  INFO 20681 --- [           main] c.h.SpringCloudRibbonClientApplication   : ::: server 2 :::
2018-04-11 22:35:28.767  INFO 20681 --- [           main] c.h.SpringCloudRibbonClientApplication   : ::: server 1 :::
2018-04-11 22:35:28.774  INFO 20681 --- [           main] c.h.SpringCloudRibbonClientApplication   : ::: server 2 :::
2018-04-11 22:35:28.786  INFO 20681 --- [           main] c.h.SpringCloudRibbonClientApplication   : ::: server 1 :::
2018-04-11 22:35:29.608  INFO 20681 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: stores.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647

```