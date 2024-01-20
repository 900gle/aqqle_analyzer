/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0 and the Server Side Public License, v 1; you may not use this file except
 * in compliance with, at your election, the Elastic License 2.0 or the Server
 * Side Public License, v 1.
 */

package com.doo.aqqle_analyzer.lucene;

import com.doo.aqqle_analyzer.elasticsearch.index.common.parser.KoreanJamoParser;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class JamoTokenFilter extends TokenFilter {


    private KoreanJamoParser parser;
    private CharTermAttribute termAtt;


    public JamoTokenFilter(TokenStream in, long tokenFilterNumber) {
        super(in);

        this.parser = new KoreanJamoParser();
        this.termAtt = addAttribute(CharTermAttribute.class);

    }

    @Override
    public boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
            CharSequence parserdData = parser.parse(termAtt.toString());
            termAtt.setEmpty();
            termAtt.append(parserdData);

            return true;
        }

        return false;
    }
}
