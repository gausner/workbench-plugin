package com.myspace;

import com.myspace.kie_server_test.Applicant;
import org.drools.workbench.screens.testscenario.backend.server.ScenarioLoader;
import org.drools.workbench.screens.testscenario.backend.server.ScenarioRunnerService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.vfs.PathFactory;

import javax.inject.Inject;

//@Model
public class WeldDrools {

        @Inject
        @KSession
        private KieSession kSession;


        @Inject
        private ScenarioRunnerService service;


//    @Inject
//    private ConfigurationService configurationService;
//
//    @Inject
//    private SessionService sessionService;
//
//    @Inject
//    private KieModuleService moduleService;
//
//    @Inject
//    private ScenarioLoader scenarioLoader;

        public void bootstrapDrools() {
//            Applicant applicant = new Applicant();
            // The KieSession was injected so we can use it now
            kSession.insert("Hi There!");

//            kSession.insert(applicant);
            int rulesFired = kSession.fireAllRules();
            System.out.println(">>> Rules Fired: "+rulesFired);
//            Path path = PathFactory.newPath("TestApplicationApproval.scenario", "default://master@MySpace/kie-server-test/src/test/resources/com/myspace/kie_server_test/TestApplicationApproval.scenario");
            Path path = PathFactory.newPath("TestApplicationApproval.scenario", "file:///Users/yshamne/Documents/projects/javaprojects/drools/workbench/plugin_poc/source/src/test/resources/com/myspace/kie_server_test/");



            service.runAllTests("userName", path);

        }

//        public static void main(String[] args) {
//            //Boostrap the CDI container, in this case WELD
//            Weld w = new Weld();
//
//            WeldContainer wc = w.initialize();
//            WeldDrools app = wc.instance().select(WeldDrools.class).get();
//            app.bootstrapDrools();
//
//            w.shutdown();
//    }

//    class TestResultMessageEventMock
//            implements Event<TestResultMessage> {
//
//        @Override
//        public void fire(TestResultMessage testResultMessage) {
//
//        }
//
//        @Override
//        public Event<TestResultMessage> select(Annotation... annotations) {
//            return null;
//        }
//
//        @Override
//        public <U extends TestResultMessage> Event<U> select(Class<U> aClass,
//                                                             Annotation... annotations) {
//            return null;
//        }
//
//        @Override
//        public <U extends TestResultMessage> Event<U> select(TypeLiteral<U> typeLiteral,
//                                             Annotation... annotations) {
//            return null;
//        }
//    }
}
