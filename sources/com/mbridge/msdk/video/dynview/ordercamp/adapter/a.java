package com.mbridge.msdk.video.dynview.ordercamp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.image.c;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.m0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.io.File;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private boolean f39098a = false;

    /* renamed from: b, reason: collision with root package name */
    private b f39099b;

    /* renamed from: c, reason: collision with root package name */
    private List<CampaignEx> f39100c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.video.dynview.ordercamp.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0559a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f39101a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f39102b;

        C0559a(ImageView imageView, boolean z10) {
            this.f39101a = imageView;
            this.f39102b = z10;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            if (this.f39102b) {
                this.f39101a.setVisibility(8);
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                this.f39101a.setImageBitmap(bitmap);
            } catch (Throwable th2) {
                o0.b("OrderCampAdapter", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f39104a;

        /* renamed from: b, reason: collision with root package name */
        MBRotationView f39105b;

        /* renamed from: c, reason: collision with root package name */
        MBridgeImageView f39106c;

        /* renamed from: d, reason: collision with root package name */
        RoundImageView f39107d;

        /* renamed from: e, reason: collision with root package name */
        TextView f39108e;

        /* renamed from: f, reason: collision with root package name */
        TextView f39109f;

        /* renamed from: g, reason: collision with root package name */
        TextView f39110g;

        /* renamed from: h, reason: collision with root package name */
        TextView f39111h;

        /* renamed from: i, reason: collision with root package name */
        MBridgeLevelLayoutView f39112i;

        /* renamed from: j, reason: collision with root package name */
        ImageView f39113j;

        /* renamed from: k, reason: collision with root package name */
        ImageView f39114k;

        /* renamed from: l, reason: collision with root package name */
        MBCusRoundImageView f39115l;

        /* renamed from: m, reason: collision with root package name */
        MBCusRoundImageView f39116m;

        /* renamed from: n, reason: collision with root package name */
        MBStarLevelLayoutView f39117n;

        /* renamed from: o, reason: collision with root package name */
        MBHeatLevelLayoutView f39118o;

        /* renamed from: p, reason: collision with root package name */
        MBFrameLayout f39119p;

        b() {
        }
    }

    public a(List<CampaignEx> list) {
        this.f39100c = list;
    }

    private int a(String str) {
        return this.f39098a ? b(str) : c(str);
    }

    private View a() {
        View inflate = LayoutInflater.from(com.mbridge.msdk.foundation.controller.c.m().d()).inflate(d("mbridge_order_layout_item"), (ViewGroup) null);
        b bVar = new b();
        this.f39099b = bVar;
        bVar.f39106c = (MBridgeImageView) inflate.findViewById(c("mbridge_lv_iv"));
        this.f39099b.f39114k = (ImageView) inflate.findViewById(c("mbridge_lv_iv_burl"));
        this.f39099b.f39107d = (RoundImageView) inflate.findViewById(c("mbridge_lv_icon_iv"));
        this.f39099b.f39112i = (MBridgeLevelLayoutView) inflate.findViewById(c("mbridge_lv_sv_starlevel"));
        this.f39099b.f39105b = (MBRotationView) inflate.findViewById(c("mbridge_lv_ration"));
        inflate.setTag(this.f39099b);
        return inflate;
    }

    private View a(int i11, List<String> list) {
        int F = k0.F(com.mbridge.msdk.foundation.controller.c.m().d());
        h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        View createDynamicView = DynamicViewCreator.getInstance().createDynamicView(new DyOption.Builder().campaignEx(this.f39100c.get(i11)).fileDirs(list).dyAdType(DyAdType.REWARD).orientation(F).adChoiceLink(t0.a(this.f39100c.get(i11))).build());
        if (createDynamicView != null) {
            this.f39098a = true;
            b bVar = new b();
            this.f39099b = bVar;
            bVar.f39115l = (MBCusRoundImageView) createDynamicView.findViewById(b("mbridge_lv_iv"));
            this.f39099b.f39114k = (ImageView) createDynamicView.findViewById(b("mbridge_lv_iv_burl"));
            this.f39099b.f39116m = (MBCusRoundImageView) createDynamicView.findViewById(b("mbridge_lv_icon_iv"));
            this.f39099b.f39117n = (MBStarLevelLayoutView) createDynamicView.findViewById(b("mbridge_lv_sv_starlevel"));
            this.f39099b.f39119p = (MBFrameLayout) createDynamicView.findViewById(b("mbridge_lv_ration"));
            createDynamicView.setTag(this.f39099b);
        }
        return createDynamicView;
    }

    private void a(int i11) {
        b bVar = this.f39099b;
        if (bVar != null) {
            if (bVar.f39108e != null) {
                this.f39099b.f39108e.setText(this.f39100c.get(i11).getAppName());
            }
            if (this.f39099b.f39109f != null) {
                this.f39099b.f39109f.setText(this.f39100c.get(i11).getAppDesc());
            }
            if (this.f39099b.f39110g != null) {
                String adCall = this.f39100c.get(i11).getAdCall();
                if (this.f39099b.f39110g instanceof MBridgeTextView) {
                    ((MBridgeTextView) this.f39099b.f39110g).setObjectAnimator(new com.mbridge.msdk.video.dynview.ui.b().a(this.f39099b.f39110g));
                }
                this.f39099b.f39110g.setText(adCall);
            }
            if (this.f39099b.f39113j != null) {
                try {
                    String language = Locale.getDefault().getLanguage();
                    Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                    if (d11 != null) {
                        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                            this.f39099b.f39113j.setImageDrawable(d11.getResources().getDrawable(d11.getResources().getIdentifier("mbridge_reward_flag_en", "drawable", com.mbridge.msdk.foundation.controller.c.m().h())));
                        } else {
                            this.f39099b.f39113j.setImageDrawable(d11.getResources().getDrawable(d11.getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", com.mbridge.msdk.foundation.controller.c.m().h())));
                        }
                    }
                } catch (Exception e11) {
                    o0.b("OrderCampAdapter", e11.getMessage());
                }
                t0.a(2, this.f39099b.f39113j, this.f39100c.get(i11), com.mbridge.msdk.foundation.controller.c.m().d(), false, null);
            }
            if (this.f39099b.f39111h != null) {
                try {
                    this.f39099b.f39111h.setText(com.mbridge.msdk.foundation.controller.c.m().d().getResources().getString(com.mbridge.msdk.foundation.controller.c.m().d().getResources().getIdentifier("mbridge_reward_viewed_text_str", "string", com.mbridge.msdk.foundation.controller.c.m().h())));
                    this.f39099b.f39111h.setVisibility(0);
                } catch (Exception e12) {
                    o0.b("OrderCampAdapter", e12.getMessage());
                }
            }
        }
    }

    private void a(int i11, ViewGroup viewGroup) {
        List<CampaignEx> list = this.f39100c;
        if (list == null || this.f39099b == null || list.size() == 0) {
            return;
        }
        MBridgeImageView mBridgeImageView = this.f39099b.f39106c;
        if (mBridgeImageView != null) {
            a(mBridgeImageView, this.f39100c.get(i11).getImageUrl(), false);
        }
        ImageView imageView = this.f39099b.f39114k;
        if (imageView != null) {
            a(imageView, this.f39100c.get(i11).getImageUrl(), false);
        }
        RoundImageView roundImageView = this.f39099b.f39107d;
        if (roundImageView != null) {
            roundImageView.setBorderRadius(25);
            a(this.f39099b.f39107d, this.f39100c.get(i11).getIconUrl(), true);
        }
        double rating = this.f39100c.get(i11).getRating();
        if (rating <= 0.0d) {
            rating = 5.0d;
        }
        MBridgeLevelLayoutView mBridgeLevelLayoutView = this.f39099b.f39112i;
        if (mBridgeLevelLayoutView != null) {
            mBridgeLevelLayoutView.setRatingAndUser(rating, this.f39100c.get(i11).getNumberRating());
            this.f39099b.f39112i.setOrientation(0);
        }
        MBRotationView mBRotationView = this.f39099b.f39105b;
        if (mBRotationView != null) {
            mBRotationView.setWidthRatio(1.0f);
            this.f39099b.f39105b.setHeightRatio(1.0f);
            this.f39099b.f39105b.setAutoscroll(false);
        }
        MBridgeImageView mBridgeImageView2 = this.f39099b.f39106c;
        if (mBridgeImageView2 != null) {
            mBridgeImageView2.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
        }
    }

    private void a(View view) {
        this.f39099b.f39104a = (RelativeLayout) view.findViewById(a("mbridge_lv_item_rl"));
        this.f39099b.f39108e = (TextView) view.findViewById(a("mbridge_lv_title_tv"));
        this.f39099b.f39110g = (TextView) view.findViewById(a("mbridge_lv_tv_install"));
        this.f39099b.f39118o = (MBHeatLevelLayoutView) view.findViewById(a("mbridge_lv_sv_heat_level"));
        this.f39099b.f39109f = (TextView) view.findViewById(a("mbridge_lv_desc_tv"));
        this.f39099b.f39113j = (ImageView) view.findViewById(a("mbridge_iv_flag"));
        this.f39099b.f39111h = (TextView) view.findViewById(a("mbridge_order_viewed_tv"));
    }

    private void a(ImageView imageView, String str, boolean z10) {
        if (imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            com.mbridge.msdk.foundation.same.image.b.a(imageView.getContext()).a(str, new C0559a(imageView, z10));
        } else if (z10) {
            imageView.setVisibility(8);
        }
    }

    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private View b(int i11) {
        View view;
        String str;
        String str2;
        try {
            List<CampaignEx> list = this.f39100c;
            str = "";
            if (list == null || list.get(i11) == null) {
                str2 = "501";
            } else {
                str2 = this.f39100c.get(i11).getMof_tplid() + "";
                str = this.f39100c.get(i11).getCMPTEntryUrl();
            }
        } catch (Exception e11) {
            o0.b("OrderCampAdapter", e11.getMessage());
            view = null;
        }
        if (TextUtils.isEmpty(str)) {
            return a();
        }
        int F = k0.F(com.mbridge.msdk.foundation.controller.c.m().d());
        String a11 = x.a(0, str2, str);
        if (TextUtils.isEmpty(a11)) {
            return a();
        }
        File file = new File(a11 + File.separator + "template_config.json");
        if (file.isFile() && file.exists()) {
            List<String> a12 = m0.a(a11, "template_" + str2 + "_" + F + "_item");
            if (a12 == null) {
                return a();
            }
            view = a(i11, a12);
            return this.f39098a ? view : a();
        }
        return a();
    }

    private void b(int i11, ViewGroup viewGroup) {
        List<CampaignEx> list = this.f39100c;
        if (list == null || this.f39099b == null || list.size() == 0) {
            return;
        }
        MBCusRoundImageView mBCusRoundImageView = this.f39099b.f39115l;
        if (mBCusRoundImageView != null) {
            mBCusRoundImageView.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
            a(this.f39099b.f39115l, this.f39100c.get(i11).getImageUrl(), false);
        }
        ImageView imageView = this.f39099b.f39114k;
        if (imageView != null) {
            a(imageView, this.f39100c.get(i11).getImageUrl(), false);
        }
        MBCusRoundImageView mBCusRoundImageView2 = this.f39099b.f39116m;
        if (mBCusRoundImageView2 != null) {
            mBCusRoundImageView2.setBorder(50, 20, -1);
            a(this.f39099b.f39116m, this.f39100c.get(i11).getIconUrl(), true);
        }
        double rating = this.f39100c.get(i11).getRating();
        if (rating <= 0.0d) {
            rating = 5.0d;
        }
        MBStarLevelLayoutView mBStarLevelLayoutView = this.f39099b.f39117n;
        if (mBStarLevelLayoutView != null) {
            mBStarLevelLayoutView.setRating((int) rating);
            this.f39099b.f39117n.setOrientation(0);
        }
        MBHeatLevelLayoutView mBHeatLevelLayoutView = this.f39099b.f39118o;
        if (mBHeatLevelLayoutView != null) {
            mBHeatLevelLayoutView.setHeatCount(this.f39100c.get(i11).getNumberRating());
        }
    }

    private int c(String str) {
        return g0.a(com.mbridge.msdk.foundation.controller.c.m().d().getApplicationContext(), str, "id");
    }

    public int d(String str) {
        return g0.a(com.mbridge.msdk.foundation.controller.c.m().d().getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<CampaignEx> list = this.f39100c;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f39100c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i11) {
        List<CampaignEx> list = this.f39100c;
        if (list != null) {
            return list.get(i11);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i11) {
        return i11;
    }

    @Override // android.widget.Adapter
    public View getView(int i11, View view, ViewGroup viewGroup) {
        try {
            if (view == null) {
                view = b(i11);
            } else {
                this.f39099b = (b) view.getTag();
            }
            a(view);
            if (this.f39098a) {
                b(i11, viewGroup);
            } else {
                a(i11, viewGroup);
            }
            a(i11);
        } catch (Exception e11) {
            o0.b("OrderCampAdapter", e11.getMessage());
        }
        return view;
    }
}
