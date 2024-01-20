//package com.doo.aqqle_analyzer.elasticsearch.plugin.analysis;
//
//import org.elasticsearch.index.analysis.TokenFilterFactory;
//import org.elasticsearch.indices.analysis.AnalysisModule;
//import org.elasticsearch.plugins.AnalysisPlugin;
//import org.elasticsearch.plugins.Plugin;
//import com.doo.aqqle_analyzer.elasticsearch.index.analysis.jamo.JamoTokenFilterFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class DooPlugin extends Plugin implements AnalysisPlugin {
//
//    @Override
//    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
//
//        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
//
////         (1) 한글 자모 분석 필터
//        extra.put("doo-jamo", JamoTokenFilterFactory::new);
//
//
//        return extra;
//
////        return AnalysisPlugin.super.getTokenFilters();
//    }
//}
