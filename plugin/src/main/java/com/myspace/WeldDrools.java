package com.myspace;

import org.drools.workbench.screens.testscenario.backend.server.ScenarioLoader;
import org.drools.workbench.screens.testscenario.backend.server.ScenarioRunnerService;
import org.guvnor.common.services.shared.test.TestResultMessage;
import org.guvnor.structure.server.config.ConfigurationService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.kie.workbench.common.services.backend.session.SessionService;
import org.kie.workbench.common.services.shared.project.KieModuleService;

import javax.enterprise.event.Event;
import javax.enterprise.util.TypeLiteral;
import javax.inject.Inject;
import java.lang.annotation.Annotation;

public class WeldDrools {

        @Inject
        @KSession
        private KieSession kSession;


       // @Inject
       // private ScenarioRunnerService service;


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

            // The KieSession was injected so we can use it now
            kSession.insert("Hi There!");
            int rulesFired = kSession.fireAllRules();
            System.out.println(">>> Rules Fired: "+rulesFired);
//            Path

//            service.runAllTests("userName", );

        }

        public static void main(String[] args) {
            //Boostrap the CDI container, in this case WELD
            Weld w = new Weld();

            WeldContainer wc = w.initialize();
            WeldDrools app = wc.instance().select(WeldDrools.class).get();
            app.bootstrapDrools();

            w.shutdown();
    }

    class TestResultMessageEventMock
            implements Event<TestResultMessage> {

        @Override
        public void fire(TestResultMessage testResultMessage) {

        }

        @Override
        public Event<TestResultMessage> select(Annotation... annotations) {
            return null;
        }

        @Override
        public <U extends TestResultMessage> Event<U> select(Class<U> aClass,
                                                             Annotation... annotations) {
            return null;
        }

        @Override
        public <U extends TestResultMessage> Event<U> select(TypeLiteral<U> typeLiteral,
                                             Annotation... annotations) {
            return null;
        }
    }
}
