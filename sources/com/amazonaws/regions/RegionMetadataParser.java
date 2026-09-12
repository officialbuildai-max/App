package com.amazonaws.regions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Deprecated
/* loaded from: classes2.dex */
public class RegionMetadataParser {
    @Deprecated
    public RegionMetadataParser() {
    }

    private static void a(Region region, Element element, boolean z10) {
        String b11 = b("ServiceName", element);
        String b12 = b("Hostname", element);
        String b13 = b("Http", element);
        String b14 = b("Https", element);
        if (!z10 || f(b12)) {
            region.h().put(b11, b12);
            region.b().put(b11, Boolean.valueOf("true".equals(b13)));
            region.c().put(b11, Boolean.valueOf("true".equals(b14)));
        } else {
            throw new IllegalStateException("Invalid service endpoint (" + b12 + ") is detected.");
        }
    }

    private static String b(String str, Element element) {
        Node item = element.getElementsByTagName(str).item(0);
        if (item == null) {
            return null;
        }
        return item.getChildNodes().item(0).getNodeValue();
    }

    private static List c(InputStream inputStream, boolean z10) {
        try {
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                NodeList elementsByTagName = parse.getElementsByTagName("Region");
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < elementsByTagName.getLength(); i11++) {
                    Node item = elementsByTagName.item(i11);
                    if (item.getNodeType() == 1) {
                        arrayList.add(d((Element) item, z10));
                    }
                }
                return arrayList;
            } catch (Throwable th2) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                throw th2;
            }
        } catch (IOException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new IOException("Unable to parse region metadata file: " + e12.getMessage(), e12);
        }
    }

    private static Region d(Element element, boolean z10) {
        Region region = new Region(b("Name", element), b("Domain", element));
        NodeList elementsByTagName = element.getElementsByTagName("Endpoint");
        for (int i11 = 0; i11 < elementsByTagName.getLength(); i11++) {
            a(region, (Element) elementsByTagName.item(i11), z10);
        }
        return region;
    }

    private static boolean f(String str) {
        return str.endsWith(".amazonaws.com");
    }

    public List e(InputStream inputStream) {
        return c(inputStream, false);
    }
}
