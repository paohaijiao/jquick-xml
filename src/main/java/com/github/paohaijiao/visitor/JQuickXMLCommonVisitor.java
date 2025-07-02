package com.github.paohaijiao.visitor;

import com.github.paohaijiao.model.JSONArray;
import com.github.paohaijiao.model.JSONObject;
import com.github.paohaijiao.parser.JQuickXMLParser;

import com.github.paohaijiao.util.JStringUtils;

public class JQuickXMLCommonVisitor extends JQuickXmlCoreVisitor {

    @Override
    public JSONObject visitDocument(JQuickXMLParser.DocumentContext ctx) {
        JSONObject object = new JSONObject();
        if (ctx.element() != null) {
            JSONObject element= visitElement(ctx.element());
            for (String key : element.keySet()) {
                object.put(key, element.get(key));
            }
        }
//        if (ctx.prolog() != null) {
//            JSONObject element= visitProlog(ctx.prolog());
//            for (String key : element.keySet()) {
//                object.put(key, element.get(key));
//            }
//        }
//        if (ctx.misc() != null) {
//            for (JQuickXMLParser.MiscContext misc : ctx.misc()) {
//                JSONObject element= visitMisc(misc);
//                for (String key : element.keySet()) {
//                    object.put(key, element.get(key));
//                }
//            }
//        }
        return object;
    }

    @Override
    public JSONObject visitProlog(JQuickXMLParser.PrologContext ctx) {
        JSONObject obj= new JSONObject();
        obj.put(prolog,ctx.getText());
        return obj;
    }

    @Override
    public Object visitContent(JQuickXMLParser.ContentContext ctx) {
        Object returnValue = null;
        JSONArray array = new JSONArray();
        String text = ctx.getText();
        System.out.println(text);
        if (ctx.element() != null && !ctx.element().isEmpty()) {
            for (JQuickXMLParser.ElementContext ele : ctx.element()) {
                JSONObject result = visitElement(ele);
                array.add(result);
            }
            returnValue = array;
        } else if (ctx.chardata() != null && !ctx.chardata().isEmpty()) {
            for (JQuickXMLParser.ChardataContext ele : ctx.chardata()) {
                String ctxString = ele.getText();
                String result = visitChardata(ele);
                returnValue = result;
            }
        }
        return returnValue;
    }

    @Override
    public JSONObject visitElement(JQuickXMLParser.ElementContext ctx) {
        JSONObject json = new JSONObject();
        String key = ctx.Name(0).getText();
        String name = ctx.getText();
        JSONArray attrs= new JSONArray();
        Object value = null;
        if (ctx.attribute() != null && !ctx.attribute().isEmpty()) {
            for (JQuickXMLParser.AttributeContext attrContext : ctx.attribute()) {
                JSONObject att = visitAttribute(attrContext);
                attrs.add(att);
            }
        }
        if (ctx.content() != null) {
            value = visitContent(ctx.content());
        }
        json.put(key, value);
        if(!attrs.isEmpty()){
            json.put(attributes,attrs);
        }
        return json;
    }

    @Override
    public JSONObject visitReference(JQuickXMLParser.ReferenceContext ctx) {
        JSONObject json = new JSONObject();
        if (ctx.EntityRef() != null) {
            json.put(entityRef, ctx.EntityRef().getText());
        } else {
            json.put(charRef, ctx.CharRef().getText());
        }
        return json;
    }

    @Override
    public JSONObject visitAttribute(JQuickXMLParser.AttributeContext ctx) {
        JSONObject attribute = new JSONObject();
        String key = ctx.Name().getText();
        String value = ctx.STRING().getText();
        String val = JStringUtils.trim(value);
        attribute.put(key, val);
        return attribute;
    }

    @Override
    public String visitChardata(JQuickXMLParser.ChardataContext ctx) {
        String str = ctx.getText();
        if (ctx.TEXT() != null) {
            String text = ctx.TEXT().getText();
            return text;
        }
        return null;
    }

    @Override
    public JSONObject visitMisc(JQuickXMLParser.MiscContext ctx) {
        JSONObject json = new JSONObject();
        if (ctx.COMMENT() != null) {
            json.put(comment, ctx.COMMENT().getText());
            return json;
        } else if (ctx.PI() != null) {
            json.put(pi, ctx.PI().getText());
            return json;
        } else if(ctx.DOCTYPE() != null){
            json.put(docType, ctx.DOCTYPE().getText());
            return json;
        }
        return json;
    }


}
