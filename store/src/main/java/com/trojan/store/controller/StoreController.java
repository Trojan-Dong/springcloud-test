package com.trojan.store.controller;/**
 * @Description
 * @Author Trojan
 * @Date 2023/4/20
 * @Version 1.0
 */

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.trojan.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName StoreController
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/20
 * @Version 1.0
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String RESOURCE_NAME = "store";

    @Value("${server.port}")
    String port;

    @RequestMapping("/add")
//    @SentinelResource(value = RESOURCE_NAME,  blockHandler = "blockHandler")
    public String add() {
        System.out.println("add store");
//        throw new RuntimeException("熔断降级");
//        Entry entry = null;
//        try {
//            entry = SphU.entry(RESOURCE_NAME);
//            logger.error(RESOURCE_NAME);
//        } catch (BlockException be) {
//            //资源访问阻止，被限流或降级
//            //进行相应的异常处理操作
//            logger.error(be.getMessage());
//            return "流量控制";
//        } catch (Exception e) {
//            e.printStackTrace();
//            //若要配置降级规则，需要通过这种方式记录业务异常
//            Tracer.traceEntry(e, entry);
//        } finally {
//            if (entry != null) {
//                entry.exit();
//            }
//        }
        return "add store" + port;
    }


    @RequestMapping("/testFallback")
    public String testFallback() {

        int a = 1 / 0;
        return "testFallback" + port;
    }

    public String blockHandler(BlockException e) {
        e.printStackTrace();
        return "熔断降级";
    }

    @Autowired
    StoreService storeService;

    @RequestMapping("/reduct")
    public String reduct(@RequestParam(value = "productId") Integer productId) {
        logger.info("productid:{}", productId);
        storeService.reduct(productId);
        return "扣减库存";
    }


   /* @PostConstruct
    private static void initFlowRule() {

        logger.info(" init FlowRule");
        List<FlowRule> rules = new ArrayList<>();

        FlowRule flowRule = new FlowRule();

        //声明流控的资源对象
        flowRule.setResource(RESOURCE_NAME);
        //设置QPS的流控规则
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源阈值
        flowRule.setCount(1);

        rules.add(flowRule);

        //加载配置好的流量规则
        FlowRuleManager.loadRules(rules);
    }*/

//    @PostConstruct
//    private static void initDeGradeRule() {
//
//        logger.info(" init DeGradeRule");
//        List<DegradeRule> rules = new ArrayList<>();
//
//        DegradeRule degradeRule = new DegradeRule();
//
//        //声明降级的资源对象
//        degradeRule.setResource(RESOURCE_NAME);
//        //设置QPS的降级规则
//        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
//        //设置受保护的资源阈值
//        degradeRule.setCount(2);
//
//        degradeRule.setMinRequestAmount(2);
//
//        degradeRule.setStatIntervalMs(10 * 1000);
//
//        degradeRule.setTimeWindow(10);
//
//        rules.add(degradeRule);
//
//        //加载配置好的流量规则
//        DegradeRuleManager.loadRules(rules);
//    }
}
