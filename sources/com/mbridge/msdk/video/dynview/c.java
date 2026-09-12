package com.mbridge.msdk.video.dynview;

import android.content.Context;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Context f39024a;

    /* renamed from: b, reason: collision with root package name */
    private String f39025b;

    /* renamed from: c, reason: collision with root package name */
    private int f39026c;

    /* renamed from: d, reason: collision with root package name */
    private float f39027d;

    /* renamed from: e, reason: collision with root package name */
    private float f39028e;

    /* renamed from: f, reason: collision with root package name */
    private int f39029f;

    /* renamed from: g, reason: collision with root package name */
    private int f39030g;

    /* renamed from: h, reason: collision with root package name */
    private View f39031h;

    /* renamed from: i, reason: collision with root package name */
    private List<CampaignEx> f39032i;

    /* renamed from: j, reason: collision with root package name */
    private int f39033j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f39034k;

    /* renamed from: l, reason: collision with root package name */
    private List<String> f39035l;

    /* renamed from: m, reason: collision with root package name */
    private int f39036m;

    /* renamed from: n, reason: collision with root package name */
    private String f39037n;

    /* renamed from: o, reason: collision with root package name */
    private int f39038o;

    /* renamed from: p, reason: collision with root package name */
    private int f39039p;

    /* renamed from: q, reason: collision with root package name */
    private String f39040q;

    /* loaded from: classes5.dex */
    public static class b implements InterfaceC0557c {

        /* renamed from: a, reason: collision with root package name */
        private Context f39041a;

        /* renamed from: b, reason: collision with root package name */
        private String f39042b;

        /* renamed from: c, reason: collision with root package name */
        private int f39043c;

        /* renamed from: d, reason: collision with root package name */
        private float f39044d;

        /* renamed from: e, reason: collision with root package name */
        private float f39045e;

        /* renamed from: f, reason: collision with root package name */
        private int f39046f;

        /* renamed from: g, reason: collision with root package name */
        private int f39047g;

        /* renamed from: h, reason: collision with root package name */
        private View f39048h;

        /* renamed from: i, reason: collision with root package name */
        private List<CampaignEx> f39049i;

        /* renamed from: j, reason: collision with root package name */
        private int f39050j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f39051k;

        /* renamed from: l, reason: collision with root package name */
        private List<String> f39052l;

        /* renamed from: m, reason: collision with root package name */
        private int f39053m;

        /* renamed from: n, reason: collision with root package name */
        private String f39054n;

        /* renamed from: o, reason: collision with root package name */
        private int f39055o;

        /* renamed from: p, reason: collision with root package name */
        private int f39056p = 1;

        /* renamed from: q, reason: collision with root package name */
        private String f39057q;

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c a(float f11) {
            this.f39045e = f11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c a(int i11) {
            this.f39050j = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c a(Context context) {
            this.f39041a = context.getApplicationContext();
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c a(View view) {
            this.f39048h = view;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c a(String str) {
            this.f39054n = str;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c a(List<CampaignEx> list) {
            this.f39049i = list;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c a(boolean z10) {
            this.f39051k = z10;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c b(float f11) {
            this.f39044d = f11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c b(int i11) {
            this.f39043c = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c b(String str) {
            this.f39057q = str;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public c build() {
            return new c(this);
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c c(int i11) {
            this.f39047g = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c c(String str) {
            this.f39042b = str;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c d(int i11) {
            this.f39053m = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c e(int i11) {
            this.f39056p = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c f(int i11) {
            this.f39055o = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c fileDirs(List<String> list) {
            this.f39052l = list;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.InterfaceC0557c
        public InterfaceC0557c orientation(int i11) {
            this.f39046f = i11;
            return this;
        }
    }

    /* renamed from: com.mbridge.msdk.video.dynview.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0557c {
        InterfaceC0557c a(float f11);

        InterfaceC0557c a(int i11);

        InterfaceC0557c a(Context context);

        InterfaceC0557c a(View view);

        InterfaceC0557c a(String str);

        InterfaceC0557c a(List<CampaignEx> list);

        InterfaceC0557c a(boolean z10);

        InterfaceC0557c b(float f11);

        InterfaceC0557c b(int i11);

        InterfaceC0557c b(String str);

        c build();

        InterfaceC0557c c(int i11);

        InterfaceC0557c c(String str);

        InterfaceC0557c d(int i11);

        InterfaceC0557c e(int i11);

        InterfaceC0557c f(int i11);

        InterfaceC0557c fileDirs(List<String> list);

        InterfaceC0557c orientation(int i11);
    }

    private c(b bVar) {
        this.f39028e = bVar.f39045e;
        this.f39027d = bVar.f39044d;
        this.f39029f = bVar.f39046f;
        this.f39030g = bVar.f39047g;
        this.f39024a = bVar.f39041a;
        this.f39025b = bVar.f39042b;
        this.f39026c = bVar.f39043c;
        this.f39031h = bVar.f39048h;
        this.f39032i = bVar.f39049i;
        this.f39033j = bVar.f39050j;
        this.f39034k = bVar.f39051k;
        this.f39035l = bVar.f39052l;
        this.f39036m = bVar.f39053m;
        this.f39037n = bVar.f39054n;
        this.f39038o = bVar.f39055o;
        this.f39039p = bVar.f39056p;
        this.f39040q = bVar.f39057q;
    }

    public static b a() {
        return new b();
    }

    public List<CampaignEx> b() {
        return this.f39032i;
    }

    public Context c() {
        return this.f39024a;
    }

    public List<String> d() {
        return this.f39035l;
    }

    public int e() {
        return this.f39038o;
    }

    public String f() {
        return this.f39025b;
    }

    public int g() {
        return this.f39026c;
    }

    public int h() {
        return this.f39029f;
    }

    public View i() {
        return this.f39031h;
    }

    public int j() {
        return this.f39030g;
    }

    public float k() {
        return this.f39027d;
    }

    public int l() {
        return this.f39033j;
    }

    public float m() {
        return this.f39028e;
    }

    public String n() {
        return this.f39040q;
    }

    public int o() {
        return this.f39039p;
    }

    public boolean p() {
        return this.f39034k;
    }
}
