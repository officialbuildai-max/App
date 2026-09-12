package com.mbridge.msdk.video.dynview.wrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.video.dynview.shape.a;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: m, reason: collision with root package name */
    private static boolean f39202m;

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.util.time.b f39203a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Bitmap> f39204b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f39205c;

    /* renamed from: d, reason: collision with root package name */
    private String f39206d = "#FFFFFFFF";

    /* renamed from: e, reason: collision with root package name */
    private String f39207e = "#60000000";

    /* renamed from: f, reason: collision with root package name */
    private String f39208f = "#FF5F5F5F";

    /* renamed from: g, reason: collision with root package name */
    private String f39209g = "#90ECECEC";

    /* renamed from: h, reason: collision with root package name */
    private volatile long f39210h = 0;

    /* renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.util.time.a f39211i = null;

    /* renamed from: j, reason: collision with root package name */
    private boolean f39212j = false;

    /* renamed from: k, reason: collision with root package name */
    private int f39213k = 0;

    /* renamed from: l, reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.inter.a f39214l = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.video.dynview.wrapper.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0566a implements com.mbridge.msdk.video.dynview.util.time.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f39215a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39216b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CampaignEx f39217c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map f39218d;

        C0566a(TextView textView, String str, CampaignEx campaignEx, Map map) {
            this.f39215a = textView;
            this.f39216b = str;
            this.f39217c = campaignEx;
            this.f39218d = map;
        }

        @Override // com.mbridge.msdk.video.dynview.util.time.a
        public void onFinish() {
            this.f39217c.setShowType(com.mbridge.msdk.foundation.same.report.metrics.a.f35629c);
            a.this.b(this.f39218d);
        }

        @Override // com.mbridge.msdk.video.dynview.util.time.a
        public void onTick(long j11) {
            a.this.f39213k = (int) (j11 / 1000);
            this.f39215a.setText(com.mbridge.msdk.video.dynview.util.a.a(a.this.f39213k, this.f39215a.getContext()));
            a.this.f39210h++;
            if (TextUtils.isEmpty(this.f39216b) || !this.f39216b.equals("1")) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, "choseFromTwoHeartbeat");
            eVar.a("xtSecond", "countTimeForReport");
            eVar.a("autoPlayCountDownTime", "mLeftOverCountTime");
            com.mbridge.msdk.video.module.report.a.a("2000103", this.f39217c, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements com.mbridge.msdk.foundation.feedback.a {
        b() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            if (a.this.f39203a != null) {
                a.this.f39203a.a();
                a.this.f39212j = true;
            }
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            if (!a.this.f39212j || a.this.f39203a == null) {
                return;
            }
            a.this.f39203a.a(a.this.f39213k * 1000, a.this.f39211i);
            a.this.f39212j = false;
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            if (!a.this.f39212j || a.this.f39203a == null) {
                return;
            }
            a.this.f39203a.a(a.this.f39213k * 1000, a.this.f39211i);
            a.this.f39212j = false;
        }
    }

    /* loaded from: classes5.dex */
    class c implements com.mbridge.msdk.video.dynview.inter.a {
        c() {
        }

        @Override // com.mbridge.msdk.video.dynview.inter.a
        public void a() {
            if (!a.this.f39212j || a.this.f39203a == null) {
                return;
            }
            a.this.f39203a.a(a.this.f39213k * 1000, a.this.f39211i);
            a.this.f39212j = false;
        }

        @Override // com.mbridge.msdk.video.dynview.inter.a
        public void b() {
            if (a.this.f39203a != null) {
                a.this.f39203a.a();
                a.this.f39212j = true;
            }
        }

        @Override // com.mbridge.msdk.video.dynview.inter.a
        public void c() {
            if (a.this.f39203a != null) {
                a.this.f39203a.a();
                a.this.f39212j = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d extends com.mbridge.msdk.widget.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f39222b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f39223c;

        d(Map map, List list) {
            this.f39222b = map;
            this.f39223c = list;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            if (a.this.f39205c) {
                return;
            }
            a.this.f39205c = true;
            a.this.a(this.f39222b, (List<CampaignEx>) this.f39223c, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e extends com.mbridge.msdk.widget.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f39225b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f39226c;

        e(Map map, List list) {
            this.f39225b = map;
            this.f39226c = list;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            if (a.this.f39205c) {
                return;
            }
            a.this.f39205c = true;
            a.this.a(this.f39225b, (List<CampaignEx>) this.f39226c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f39228a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f39229b;

        f(Map map, List list) {
            this.f39228a = map;
            this.f39229b = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            a.this.a(this.f39228a, (List<CampaignEx>) this.f39229b, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f39231a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f39232b;

        g(Map map, List list) {
            this.f39231a = map;
            this.f39232b = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            a.this.a(this.f39231a, (List<CampaignEx>) this.f39232b, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f39234a;

        h(Map map) {
            this.f39234a = map;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f39234a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class i implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f39236a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f39237b;

        /* renamed from: com.mbridge.msdk.video.dynview.wrapper.a$i$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0567a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f39239a;

            /* renamed from: com.mbridge.msdk.video.dynview.wrapper.a$i$a$a, reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class RunnableC0568a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Bitmap f39241a;

                RunnableC0568a(Bitmap bitmap) {
                    this.f39241a = bitmap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    i.this.f39237b.setImageBitmap(this.f39241a);
                }
            }

            RunnableC0567a(Bitmap bitmap) {
                this.f39239a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    i.this.f39237b.post(new RunnableC0568a(y.a(this.f39239a, 10)));
                } catch (Exception e11) {
                    o0.b("DataEnergizeWrapper", e11.getMessage());
                }
            }
        }

        i(int i11, ImageView imageView) {
            this.f39236a = i11;
            this.f39237b = imageView;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            try {
                int a11 = g0.a(this.f39237b.getContext(), "mbridge_icon_play_bg", "drawable");
                this.f39237b.setBackgroundColor(Color.parseColor(a.this.f39208f));
                this.f39237b.setImageResource(a11);
                this.f39237b.setScaleType(ImageView.ScaleType.CENTER);
            } catch (Exception e11) {
                o0.a("DataEnergizeWrapper", e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                int a11 = g0.a(this.f39237b.getContext(), "mbridge_icon_play_bg", "drawable");
                this.f39237b.setBackgroundColor(Color.parseColor(a.this.f39208f));
                this.f39237b.setImageResource(a11);
                this.f39237b.setScaleType(ImageView.ScaleType.CENTER);
                return;
            }
            int i11 = this.f39236a;
            if (i11 != 501 && i11 != 802) {
                this.f39237b.setImageBitmap(bitmap);
            } else {
                com.mbridge.msdk.foundation.same.threadpool.a.a().execute(new RunnableC0567a(bitmap));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class j implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f39243a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39244b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.video.dynview.c f39245c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f39246d;

        j(ImageView imageView, String str, com.mbridge.msdk.video.dynview.c cVar, View view) {
            this.f39243a = imageView;
            this.f39244b = str;
            this.f39245c = cVar;
            this.f39246d = view;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            ImageView imageView;
            if (bitmap == null || bitmap.isRecycled() || (imageView = this.f39243a) == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
            if (a.this.f39204b != null) {
                a.this.f39204b.put(SameMD5.getMD5(this.f39244b), bitmap);
                a.this.a(this.f39245c, this.f39246d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class k extends com.mbridge.msdk.widget.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f39248b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f39249c;

        k(CampaignEx campaignEx, Map map) {
            this.f39248b = campaignEx;
            this.f39249c = map;
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            if (a.this.f39205c) {
                return;
            }
            a.this.f39205c = true;
            this.f39248b.setShowType(com.mbridge.msdk.foundation.same.report.metrics.a.f35630d);
            a.this.b(this.f39249c);
        }
    }

    private int a(boolean z10, String str) {
        try {
            if (!z10) {
                return g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, "id");
            }
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return str.hashCode();
        } catch (Exception e11) {
            o0.b("DataEnergizeWrapper", e11.getMessage());
            return -1;
        }
    }

    private Bitmap a() {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
            bitmap.eraseColor(Color.parseColor(this.f39209g));
            return bitmap;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return bitmap;
            }
            e11.printStackTrace();
            return bitmap;
        }
    }

    private void a(ImageView imageView, String str, int i11) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.image.b.a(imageView.getContext()).a(str, new i(i11, imageView));
    }

    private void a(ListView listView, com.mbridge.msdk.video.dynview.c cVar) {
        if (listView == null || cVar == null) {
            return;
        }
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) listView.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.height = -1;
            float k11 = (cVar.k() - t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 720.0f)) / 2.0f;
            int a11 = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f);
            int i11 = (int) k11;
            layoutParams.setMargins(a11, i11, a11, i11);
            listView.setLayoutParams(layoutParams);
        } catch (Exception e11) {
            o0.b("DataEnergizeWrapper", e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.video.dynview.c cVar, View view) {
        Map<String, Bitmap> map = this.f39204b;
        if (map == null || map.size() <= 1) {
            return;
        }
        new com.mbridge.msdk.video.dynview.ui.b().a(this.f39204b, cVar, view);
    }

    private void a(String str, Context context, View view, int i11, Map map, CampaignEx campaignEx) {
        String a11 = z0.a(str, "cltp");
        String a12 = z0.a(str, "xt");
        long parseLong = !TextUtils.isEmpty(a11) ? Long.parseLong(a11) : 0L;
        if (parseLong != 0) {
            if (map != null && map.containsKey("is_dy_success")) {
                f39202m = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            TextView textView = (TextView) view.findViewById(a(f39202m, "mbridge_choice_one_countdown_tv"));
            if (textView != null) {
                textView.setTextSize(11.0f);
                textView.setTextColor(Color.parseColor(this.f39206d));
                String str2 = this.f39207e;
                com.mbridge.msdk.video.dynview.util.drawable.a.a(textView, 1, 12, str2, str2);
                textView.setVisibility(0);
                textView.setOnClickListener(new k(campaignEx, map));
                this.f39211i = new C0566a(textView, a12, campaignEx, map);
                com.mbridge.msdk.video.dynview.util.time.b a13 = new com.mbridge.msdk.video.dynview.util.time.b().b(parseLong * 1000).a(1000L).a(this.f39211i);
                this.f39203a = a13;
                a13.c();
            }
            ImageView imageView = (ImageView) view.findViewById(a(f39202m, "mbridge_iv_link"));
            if (campaignEx == null) {
                return;
            }
            if (campaignEx.getAdchoice() != null) {
                campaignEx.getAdchoice().g("");
            }
            t0.a(4, imageView, campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), false, new b());
        }
    }

    private void a(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        a(imageView, str, -1);
    }

    private void a(String str, ImageView imageView, com.mbridge.msdk.video.dynview.c cVar, View view) {
        com.mbridge.msdk.foundation.same.image.b.a(imageView.getContext()).a(str, new j(imageView, str, cVar, view));
        try {
            Bitmap a11 = a();
            if (a11 == null || a11.isRecycled()) {
                return;
            }
            b(cVar, view);
        } catch (Exception e11) {
            o0.b("DataEnergizeWrapper", e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map map) {
        if (map != null) {
            try {
                if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.listener.c)) {
                    ((com.mbridge.msdk.video.dynview.listener.c) map.get("order_view_callback")).close();
                    b();
                }
            } catch (Exception e11) {
                o0.b("DataEnergizeWrapper", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map map, List<CampaignEx> list, int i11) {
        if (map == null || list == null || list.size() <= 1) {
            return;
        }
        if (!map.containsKey("choice_one_callback") || !(map.get("choice_one_callback") instanceof com.mbridge.msdk.video.dynview.listener.d)) {
            if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.listener.c)) {
                com.mbridge.msdk.video.dynview.listener.c cVar = (com.mbridge.msdk.video.dynview.listener.c) map.get("order_view_callback");
                if (cVar != null) {
                    cVar.a(list.get(i11), i11);
                }
                b();
                return;
            }
            return;
        }
        com.mbridge.msdk.video.dynview.listener.d dVar = (com.mbridge.msdk.video.dynview.listener.d) map.get("choice_one_callback");
        if (dVar != null) {
            dVar.a(list.get(i11));
            try {
                CampaignEx campaignEx = list.get(i11);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("click", "0");
                eVar.a(EventConstants.KEY_TIME, Long.valueOf(this.f39210h));
                eVar.a("choose_cid", campaignEx.getId());
                eVar.a(RequestParameters.POSITION, Integer.valueOf(i11));
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, "choseFromTwoSelect");
                com.mbridge.msdk.video.module.report.a.a("2000103", campaignEx, eVar);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
        b();
    }

    private void b() {
        com.mbridge.msdk.video.dynview.util.draw.a.a().b();
        com.mbridge.msdk.video.dynview.util.time.b bVar = this.f39203a;
        if (bVar != null) {
            bVar.a();
            this.f39203a = null;
        }
        com.mbridge.msdk.video.dynview.energize.a.a().f39064a = null;
        if (this.f39214l != null) {
            this.f39214l = null;
        }
        Map<String, Bitmap> map = this.f39204b;
        if (map != null) {
            if (map.entrySet() != null) {
                try {
                    Iterator<Map.Entry<String, Bitmap>> it = this.f39204b.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, Bitmap> next = it.next();
                        if (next != null && next.getValue() != null && !next.getValue().isRecycled()) {
                            next.getValue().recycle();
                        }
                        it.remove();
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            this.f39204b.clear();
        }
    }

    private void b(com.mbridge.msdk.video.dynview.c cVar, View view) {
        a.b a11 = com.mbridge.msdk.video.dynview.shape.a.a();
        a11.a(cVar.h()).a(true);
        if (cVar.h() != 2) {
            a11.b(cVar.m()).a(cVar.k());
        } else if (cVar.m() > cVar.k()) {
            a11.b(cVar.m()).a(cVar.k());
        } else {
            a11.b(cVar.k()).a(cVar.m());
        }
        if (view.getBackground() == null) {
            view.setBackground(a11.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map map) {
        if (map != null) {
            try {
                if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof com.mbridge.msdk.video.dynview.listener.d)) {
                    ((com.mbridge.msdk.video.dynview.listener.d) map.get("choice_one_callback")).a();
                    b();
                }
            } catch (Exception e11) {
                o0.b("DataEnergizeWrapper", e11.getMessage());
            }
        }
    }

    public void a(com.mbridge.msdk.video.dynview.c cVar, View view, com.mbridge.msdk.video.dynview.listener.e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_VIEWOPTION);
            return;
        }
        try {
            ImageView imageView = (ImageView) view.findViewById(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_iv_adbanner_bg", "id"));
            if (imageView != null) {
                imageView.setBackgroundColor(Color.parseColor(this.f39209g));
            }
            ImageView imageView2 = (ImageView) view.findViewById(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_iv_adbanner", "id"));
            if (imageView2 != null) {
                imageView2.setBackgroundColor(Color.parseColor(this.f39209g));
            }
            eVar.a(view, new ArrayList());
        } catch (Exception e11) {
            o0.a("DataEnergizeWrapper", e11.getMessage());
            eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_VIEWOPTION);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.mbridge.msdk.video.dynview.c r35, android.view.View r36, java.util.Map r37, com.mbridge.msdk.video.dynview.listener.e r38) {
        /*
            Method dump skipped, instructions count: 828
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.wrapper.a.a(com.mbridge.msdk.video.dynview.c, android.view.View, java.util.Map, com.mbridge.msdk.video.dynview.listener.e):void");
    }

    public void b(com.mbridge.msdk.video.dynview.c cVar, View view, Map map, com.mbridge.msdk.video.dynview.listener.e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_VIEWOPTION);
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            f39202m = ((Boolean) map.get("is_dy_success")).booleanValue();
        }
        boolean z10 = f39202m;
        LinearLayout linearLayout = z10 ? (LinearLayout) view.findViewById(a(z10, "mbridge_reward_heat_mllv")) : null;
        ImageView imageView = (ImageView) view.findViewById(a(f39202m, "mbridge_reward_icon_riv"));
        TextView textView = (TextView) view.findViewById(a(f39202m, "mbridge_reward_title_tv"));
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(a(f39202m, "mbridge_reward_stars_mllv"));
        TextView textView2 = (TextView) view.findViewById(a(f39202m, "mbridge_reward_click_tv"));
        ImageView imageView2 = (ImageView) view.findViewById(a(f39202m, "mbridge_videoview_bg"));
        TextView textView3 = (TextView) view.findViewById(a(f39202m, "mbridge_reward_desc_tv"));
        View view2 = (RelativeLayout) view.findViewById(a(f39202m, "mbridge_reward_bottom_layout"));
        List<View> arrayList = new ArrayList<>();
        List<CampaignEx> b11 = cVar.b();
        if (b11 == null || b11.size() <= 0) {
            eVar.a(com.mbridge.msdk.video.dynview.error.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        CampaignEx campaignEx = b11.get(0);
        if (campaignEx == null) {
            eVar.a(com.mbridge.msdk.video.dynview.error.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (imageView != null) {
            if (!f39202m) {
                ((RoundImageView) imageView).setBorderRadius(10);
            } else if (imageView instanceof MBCusRoundImageView) {
                ((MBCusRoundImageView) imageView).setCustomBorder(30, 30, 30, 30, 10, -1);
            }
            a(campaignEx.getIconUrl(), imageView);
        }
        if (textView != null) {
            textView.setText(campaignEx.getAppName());
        }
        if (textView3 != null) {
            textView3.setText(campaignEx.getAppDesc());
        }
        if (linearLayout2 != null) {
            double rating = campaignEx.getRating();
            if (rating <= 0.0d) {
                rating = 5.0d;
            }
            if (f39202m) {
                if (linearLayout2 instanceof MBStarLevelLayoutView) {
                    MBStarLevelLayoutView mBStarLevelLayoutView = (MBStarLevelLayoutView) linearLayout2;
                    mBStarLevelLayoutView.setRating((int) rating);
                    mBStarLevelLayoutView.setOrientation(0);
                }
                if (linearLayout instanceof MBHeatLevelLayoutView) {
                    ((MBHeatLevelLayoutView) linearLayout).setHeatCount(campaignEx.getNumberRating());
                }
            } else {
                ((MBridgeLevelLayoutView) linearLayout2).setRatingAndUser(rating, campaignEx.getNumberRating());
            }
        }
        if (textView2 != null) {
            textView2.setText(campaignEx.getAdCall());
        }
        int l11 = cVar.l();
        if (l11 == 102 || l11 == 202 || l11 == 302) {
            if (textView2 != null) {
                arrayList.add(textView2);
            }
        } else if (l11 == 802) {
            if (imageView != null) {
                arrayList.add(imageView);
            }
            if (textView2 != null) {
                arrayList.add(textView2);
            }
            a(imageView2, campaignEx.getImageUrl(), l11);
        } else if (l11 != 902) {
            if (l11 != 904) {
                if (l11 == 5002010) {
                    if (cVar.p() && view2 != null && view2.getVisibility() == 0) {
                        arrayList.add(view2);
                    } else {
                        if (imageView != null) {
                            arrayList.add(imageView);
                        }
                        if (textView2 != null) {
                            arrayList.add(textView2);
                        }
                    }
                }
            } else if (cVar.p()) {
                arrayList.add(view);
            }
        } else if (TextUtils.isEmpty(cVar.n()) || !cVar.n().equals("dsp") || !TextUtils.isEmpty(campaignEx.getClickURL())) {
            arrayList.add(view);
        }
        eVar.a(view, arrayList);
    }

    public void c(com.mbridge.msdk.video.dynview.c cVar, View view, Map map, com.mbridge.msdk.video.dynview.listener.e eVar) {
        try {
            if (this.f39204b == null) {
                this.f39204b = new HashMap();
            }
            List<CampaignEx> b11 = cVar.b();
            if (view.getContext() == null) {
                eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_CONTEXT);
                return;
            }
            if (map != null && map.containsKey("is_dy_success")) {
                f39202m = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            for (CampaignEx campaignEx : b11) {
                if (campaignEx != null) {
                    campaignEx.setECTemplateRenderSucc(f39202m);
                }
            }
            ListView listView = (ListView) view.findViewById(a(f39202m, "mbridge_order_view_lv"));
            GridView gridView = (GridView) view.findViewById(a(f39202m, "mbridge_order_view_h_lv"));
            ImageView imageView = (ImageView) view.findViewById(a(f39202m, "mbridge_order_view_iv_close"));
            com.mbridge.msdk.video.dynview.ordercamp.adapter.a aVar = new com.mbridge.msdk.video.dynview.ordercamp.adapter.a(b11);
            if (cVar.h() == 1) {
                if (listView != null) {
                    a(listView, cVar);
                    listView.setAdapter((ListAdapter) aVar);
                    listView.setOnItemClickListener(new f(map, b11));
                }
            } else if (gridView != null) {
                int m11 = (int) cVar.m();
                int size = m11 / b11.size();
                int i11 = size / 9;
                int i12 = i11 / 2;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gridView.getLayoutParams();
                layoutParams.width = m11 - (i11 * 2);
                gridView.setLayoutParams(layoutParams);
                gridView.setColumnWidth((size - i11) - (i12 / 2));
                gridView.setHorizontalSpacing(i12);
                gridView.setStretchMode(0);
                gridView.setNumColumns(b11.size());
                gridView.setAdapter((ListAdapter) aVar);
                gridView.setOnItemClickListener(new g(map, b11));
            }
            if (imageView != null) {
                imageView.setOnClickListener(new h(map));
            }
            if (eVar != null) {
                eVar.a(view, null);
            }
        } catch (Exception unused) {
            if (eVar != null) {
                eVar.a(com.mbridge.msdk.video.dynview.error.a.NOT_FOUND_VIEWOPTION);
            }
        }
    }
}
