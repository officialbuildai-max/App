package org.apache.tools.ant.util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.tools.ant.BuildException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final d f71691a = d.k();

    /* renamed from: b, reason: collision with root package name */
    private static SAXParserFactory f71692b = null;

    /* renamed from: c, reason: collision with root package name */
    private static SAXParserFactory f71693c = null;

    /* renamed from: d, reason: collision with root package name */
    private static DocumentBuilderFactory f71694d = null;

    private static BuildException a(SAXException sAXException) {
        Exception exception = sAXException.getException();
        return exception != null ? new BuildException(exception) : new BuildException(sAXException);
    }

    public static synchronized SAXParserFactory b() {
        SAXParserFactory sAXParserFactory;
        synchronized (e.class) {
            try {
                if (f71693c == null) {
                    SAXParserFactory d11 = d();
                    f71693c = d11;
                    d11.setNamespaceAware(true);
                }
                sAXParserFactory = f71693c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return sAXParserFactory;
    }

    public static XMLReader c() {
        try {
            return e(b()).getXMLReader();
        } catch (SAXException e11) {
            throw a(e11);
        }
    }

    public static SAXParserFactory d() {
        try {
            return SAXParserFactory.newInstance();
        } catch (FactoryConfigurationError e11) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("XML parser factory has not been configured correctly: ");
            stringBuffer.append(e11.getMessage());
            throw new BuildException(stringBuffer.toString(), e11);
        }
    }

    private static SAXParser e(SAXParserFactory sAXParserFactory) {
        try {
            return sAXParserFactory.newSAXParser();
        } catch (ParserConfigurationException e11) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot create parser for the given configuration: ");
            stringBuffer.append(e11.getMessage());
            throw new BuildException(stringBuffer.toString(), e11);
        } catch (SAXException e12) {
            throw a(e12);
        }
    }
}
