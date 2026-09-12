package com.mbridge.msdk.foundation.same.directory;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class d extends b {
    public d(String str) {
        super(str);
    }

    @Override // com.mbridge.msdk.foundation.same.directory.b
    protected List<a> b() {
        ArrayList<a> arrayList = new ArrayList<>();
        a(arrayList, c.MBRIDGE_RES_MANAGER_DIR, "mb/res");
        a(arrayList, c.AD_MOVIES, "mb/res/Movies").a(c.MBRIDGE_VC, "mb/res/.MBridge_VC");
        a a11 = a(arrayList, c.AD_MBRIDGE_700, "mb/res/.mbridge700");
        a11.a(c.MBRIDGE_700_IMG, "mb/res/img");
        a11.a(c.MBRIDGE_700_IMG_PICASSO, "mb/res/picasso");
        a11.a(c.MBRIDGE_700_RES, "mb/res/res");
        a11.a(c.MBRIDGE_700_HTML, "mb/res/html");
        a11.a(c.MBRIDGE_700_XML, "mb/res/xml");
        a11.a(c.MBRIDGE_700_CONFIG, "mb/config");
        c cVar = c.MBRIDGE_OTHER;
        a(arrayList, cVar, "mb/other");
        a(arrayList, c.MBRIDGE_CRASH_INFO, "mb/crashinfo");
        a(arrayList, cVar, "mb/other");
        return arrayList;
    }
}
