package com.doo.aqqle_analyzer.lucene;

import com.doo.aqqle_analyzer.elasticsearch.index.common.parser.KoreanJamoParser;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

/**
 * 스펠링 체크 필터
 *
 * @author hrkim
 *
 */
public final class SpellFilter extends TokenFilter {
    
    private KoreanJamoParser parser;
    private CharTermAttribute termAtt;

    
    public SpellFilter(TokenStream stream) {
        super(stream);
        this.parser = new KoreanJamoParser();
        this.termAtt = addAttribute(CharTermAttribute.class);
    }

    
    /**
     * 한글 자모 Parser를 이용하여 토큰을 파싱하고 Term을 구한다. 
     */
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
