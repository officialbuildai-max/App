package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public class XpathUtils {

    /* renamed from: a, reason: collision with root package name */
    private static Log f19104a = LogFactory.b(XpathUtils.class);

    /* renamed from: b, reason: collision with root package name */
    private static DocumentBuilderFactory f19105b = DocumentBuilderFactory.newInstance();

    public static Node a(String str, Node node) {
        if (node == null) {
            return null;
        }
        return (Node) g().evaluate(str, node, XPathConstants.NODE);
    }

    public static String b(String str, Node node) {
        return e(str, node);
    }

    public static Document c(InputStream inputStream) {
        NamespaceRemovingInputStream namespaceRemovingInputStream = new NamespaceRemovingInputStream(inputStream);
        Document parse = f19105b.newDocumentBuilder().parse(namespaceRemovingInputStream);
        namespaceRemovingInputStream.close();
        return parse;
    }

    public static Document d(String str) {
        return c(new ByteArrayInputStream(str.getBytes(StringUtils.f19086a)));
    }

    private static String e(String str, Node node) {
        if (f(node)) {
            return null;
        }
        if (".".equals(str) || a(str, node) != null) {
            return g().evaluate(str, node).trim();
        }
        return null;
    }

    public static boolean f(Node node) {
        return node == null;
    }

    public static XPath g() {
        return XPathFactory.newInstance().newXPath();
    }
}
