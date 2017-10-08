package com.pad.common;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

/**
 * Created by pad on 17-9-29.
 */
public class FlexibleUtils {

    public static String parseToHtml(String mdStr){
        MutableDataSet options=new MutableDataSet();

        Parser parser= Parser.builder(options).build();
        HtmlRenderer renderer= HtmlRenderer.builder(options).build();

        Node doc=parser.parse(mdStr);
        String html=renderer.render(doc);
        return html;
    }
}
