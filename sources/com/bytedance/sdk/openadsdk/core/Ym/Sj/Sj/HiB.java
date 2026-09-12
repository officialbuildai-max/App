package com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.bytedance.sdk.openadsdk.core.Ym.Sj.sP;
import com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj;
import com.bytedance.sdk.openadsdk.core.Ym.sP.TKC;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class HiB extends com.bytedance.sdk.openadsdk.core.Ym.Sj.sP {
    public static final String Jcg = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Sj {
        String EjP;
        String Sj;
        Sj.sP TKC;
        Sj.EnumC0275Sj sP;
        final List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> HiB = new ArrayList();
        final List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> vS = new ArrayList();
        float Jcg = Float.MIN_VALUE;

        public Sj() {
        }

        public Sj(String str, Sj.EnumC0275Sj enumC0275Sj, Sj.sP sPVar) {
            Sj(str, enumC0275Sj, sPVar);
        }

        public void Sj(String str) {
            this.HiB.add(new TKC.Sj(str).Sj());
        }

        public void Sj(String str, Sj.EnumC0275Sj enumC0275Sj, Sj.sP sPVar) {
            this.Sj = str;
            this.sP = enumC0275Sj;
            this.TKC = sPVar;
        }

        public void sP(String str) {
            this.vS.add(new TKC.Sj(str).Sj());
        }
    }

    public HiB(Context context, int i11, int i12) {
        super(context, i11, i12);
    }

    private static List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> EjP(String str) {
        return Sj(str, false);
    }

    private com.bytedance.sdk.openadsdk.core.Ym.Sj Sj(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) throws IOException, XmlPullParserException {
        xmlPullParser.require(2, Jcg, "VAST");
        boolean z10 = false;
        String str = null;
        while (xmlPullParser.next() != 1) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if ("Error".equals(name)) {
                    str = sP(xmlPullParser, name);
                } else if ("Ad".equals(name)) {
                    if (Sj(xmlPullParser.getAttributeValue(Jcg, "sequence"))) {
                        while (true) {
                            if (xmlPullParser.next() == 3 && "Ad".equals(xmlPullParser.getName())) {
                                break;
                            }
                            if (xmlPullParser.getEventType() == 2) {
                                String name2 = xmlPullParser.getName();
                                if ("InLine".equals(name2)) {
                                    com.bytedance.sdk.openadsdk.core.Ym.Sj Sj2 = sP.Sj(this.sP, xmlPullParser, list, this.TKC, this.EjP);
                                    if (Sj2 != null) {
                                        if (!TextUtils.isEmpty(Sj2.Jcg())) {
                                            return Sj2;
                                        }
                                        this.HiB = -6;
                                        return null;
                                    }
                                } else if ("Wrapper".equals(name2)) {
                                    com.bytedance.sdk.openadsdk.core.Ym.Sj sP = sP(xmlPullParser, list);
                                    if (sP != null) {
                                        return sP;
                                    }
                                } else {
                                    Sj(xmlPullParser);
                                }
                            }
                        }
                    } else {
                        Sj(xmlPullParser);
                    }
                    z10 = true;
                } else {
                    Sj(xmlPullParser);
                }
            }
        }
        if (!z10) {
            this.HiB = -4;
            TKC(str);
        }
        if (this.HiB == 0) {
            this.HiB = -5;
        }
        return null;
    }

    private static List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> Sj(String str, boolean z10) {
        return TextUtils.isEmpty(str) ? new ArrayList() : Collections.singletonList(new TKC.Sj(str).Sj(z10).Sj());
    }

    public static List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> Sj(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        return EjP(sP(xmlPullParser, str));
    }

    private void Sj(com.bytedance.sdk.openadsdk.core.Ym.Sj sj2) {
        if (this.vS == null) {
            this.vS = new sP.Sj();
        }
        sP.Sj sj3 = this.vS;
        sj3.Sj = this.HiB;
        sj3.sP = this.Sj;
        if (sj2 != null) {
            sj3.TKC = sj2.Sj().sP.size() <= 0;
        }
    }

    public static void Sj(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i11 = 1;
        while (i11 != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i11++;
            } else if (next == 3) {
                i11--;
            }
        }
    }

    public static void Sj(XmlPullParser xmlPullParser, String str, int i11) throws XmlPullParserException, IOException {
        while (xmlPullParser.getEventType() != 1) {
            if (str.equals(xmlPullParser.getName()) && xmlPullParser.getEventType() == i11) {
                return;
            } else {
                xmlPullParser.next();
            }
        }
    }

    private void TKC(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(Collections.singletonList(new TKC.Sj(str).Sj()), this.Sj > 0 ? com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.NO_ADS_VAST_RESPONSE : com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.UNDEFINED_ERROR, -1L, null), (TKC.sP) null);
    }

    public static int sP(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return Integer.MIN_VALUE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e4, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x005e. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bytedance.sdk.openadsdk.core.Ym.Sj sP(org.xmlpull.v1.XmlPullParser r18, java.util.List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> r19) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.sP(org.xmlpull.v1.XmlPullParser, java.util.List):com.bytedance.sdk.openadsdk.core.Ym.Sj");
    }

    public static String sP(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        String str2;
        String str3 = Jcg;
        xmlPullParser.require(2, str3, str);
        if (xmlPullParser.next() == 4) {
            str2 = xmlPullParser.getText().trim();
            xmlPullParser.nextTag();
        } else {
            str2 = "";
        }
        xmlPullParser.require(3, str3, str);
        return str2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    @Override // com.bytedance.sdk.openadsdk.core.Ym.Sj.sP
    public com.bytedance.sdk.openadsdk.core.Ym.Sj Sj(String str, List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) {
        ByteArrayInputStream byteArrayInputStream;
        this.HiB = 0;
        InputStream inputStream = null;
        if (this.sP == null) {
            this.HiB = -1;
            return null;
        }
        ?? isEmpty = TextUtils.isEmpty(str);
        try {
            if (isEmpty != 0) {
                this.HiB = -2;
                return null;
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
                try {
                    XmlPullParser newPullParser = Xml.newPullParser();
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                    newPullParser.setInput(byteArrayInputStream, "UTF-8");
                    newPullParser.nextTag();
                    com.bytedance.sdk.openadsdk.core.Ym.Sj Sj2 = Sj(newPullParser, list);
                    Sj(Sj2);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException unused) {
                    }
                    return Sj2;
                } catch (Exception unused2) {
                    this.HiB = -3;
                    Sj((com.bytedance.sdk.openadsdk.core.Ym.Sj) null);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            } catch (Exception unused4) {
                byteArrayInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = isEmpty;
        }
    }
}
