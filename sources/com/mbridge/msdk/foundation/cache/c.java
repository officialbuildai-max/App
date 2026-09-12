package com.mbridge.msdk.foundation.cache;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: i, reason: collision with root package name */
    public static int f35035i = 1;

    /* renamed from: j, reason: collision with root package name */
    public static int f35036j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static int f35037k = 3;

    /* renamed from: l, reason: collision with root package name */
    public static int f35038l = 2;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f35039a;

    /* renamed from: b, reason: collision with root package name */
    private String f35040b;

    /* renamed from: c, reason: collision with root package name */
    private int f35041c = 21;

    /* renamed from: d, reason: collision with root package name */
    private int f35042d = f35036j;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<String> f35043e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private List<String> f35044f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private List<String> f35045g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private List<String> f35046h = new ArrayList();

    public String a() {
        ArrayList<String> arrayList = this.f35043e;
        return arrayList == null ? "" : arrayList.toString();
    }

    public void a(int i11) {
        this.f35042d = i11;
    }

    public void a(String str) {
        try {
            ArrayList<String> arrayList = this.f35043e;
            if (arrayList != null) {
                arrayList.add(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f35039a = copyOnWriteArrayList;
    }

    public String b() {
        List<String> list = this.f35046h;
        return list == null ? "" : list.toString();
    }

    public void b(String str) {
        try {
            List<String> list = this.f35045g;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public CopyOnWriteArrayList<CampaignEx> c() {
        return this.f35039a;
    }

    public void c(String str) {
        try {
            List<String> list = this.f35044f;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String d() {
        List<String> list = this.f35045g;
        return list == null ? "" : list.toString();
    }

    public void d(String str) {
        this.f35040b = str;
    }

    public String e() {
        return this.f35040b;
    }

    public String f() {
        List<String> list = this.f35044f;
        return list == null ? "" : list.toString();
    }

    public int g() {
        return this.f35042d;
    }
}
