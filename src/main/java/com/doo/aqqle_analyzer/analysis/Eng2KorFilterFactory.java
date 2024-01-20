/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0 and the Server Side Public License, v 1; you may not use this file except
 * in compliance with, at your election, the Elastic License 2.0 or the Server
 * Side Public License, v 1.
 */

package com.doo.aqqle_analyzer.analysis;

import com.doo.aqqle_analyzer.lucene.Eng2KorConvertFilter;
import com.doo.aqqle_analyzer.lucene.JamoTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.plugin.Inject;
import org.elasticsearch.plugin.NamedComponent;
import org.elasticsearch.plugin.analysis.AnalysisMode;
import org.elasticsearch.plugin.analysis.TokenFilterFactory;

@NamedComponent( "eng2kor")
public class Eng2KorFilterFactory implements TokenFilterFactory {
    private final long tokenFilterNumber;

    @Inject
    public Eng2KorFilterFactory(ExampleAnalysisSettings settings) {
        this.tokenFilterNumber = settings.digitToSkipInTokenFilter();
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new Eng2KorConvertFilter(tokenStream);
    }

    @Override
    public TokenStream normalize(TokenStream tokenStream) {
        return new Eng2KorConvertFilter(tokenStream);
    }

    @Override
    public AnalysisMode getAnalysisMode() {
        return TokenFilterFactory.super.getAnalysisMode();
    }

}

