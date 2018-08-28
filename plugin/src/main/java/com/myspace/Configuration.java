package com.myspace;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.jboss.errai.security.shared.api.identity.User;
import org.jboss.errai.security.shared.api.identity.UserImpl;
import org.kie.workbench.common.services.refactoring.backend.server.indexing.ImpactAnalysisAnalyzerWrapper;
import org.kie.workbench.common.services.refactoring.backend.server.indexing.ImpactAnalysisAnalyzerWrapperFactory;
import org.kie.workbench.common.services.refactoring.backend.server.indexing.LowerCaseOnlyAnalyzer;
import org.uberfire.ext.metadata.backend.lucene.LuceneConfig;
import org.uberfire.ext.metadata.backend.lucene.analyzer.FilenameAnalyzer;
import org.uberfire.ext.metadata.backend.lucene.fields.SimpleFieldFactory;
import org.uberfire.ext.metadata.backend.lucene.metamodel.InMemoryMetaModelStore;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class Configuration {

    @Produces @Named
    public LuceneConfig getLuceneConfig(){
        StandardAnalyzer defaultAnalyzer = new StandardAnalyzer();
        Map<String, Analyzer> fieldAnalyzers = new HashMap<>();

        FilenameAnalyzer filenameAnalyzer = new FilenameAnalyzer();
        LowerCaseOnlyAnalyzer lowerCaseOnlyAnalyzer = new LowerCaseOnlyAnalyzer();

        fieldAnalyzers.put("projectRoot", filenameAnalyzer);
        fieldAnalyzers.put("libraryFileName", filenameAnalyzer);
        fieldAnalyzers.put("filename", filenameAnalyzer);
        fieldAnalyzers.put("libraryRepositoryRoot", filenameAnalyzer);
        fieldAnalyzers.put("packageName", lowerCaseOnlyAnalyzer);

        Analyzer analyzer = ImpactAnalysisAnalyzerWrapperFactory.getInstance().getAnalyzerWrapper(defaultAnalyzer, fieldAnalyzers ) ;
        return new LuceneConfig(new InMemoryMetaModelStore(), new SimpleFieldFactory(), null, analyzer);
    }

    @Produces @Named
    public User getUser(){
        return new UserImpl("Maven user");
    }

}
