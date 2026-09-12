package com.mbridge.msdk.nativex.view.mbfullview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes5.dex */
public class BaseView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    protected RelativeLayout f36751a;

    /* renamed from: b, reason: collision with root package name */
    protected RelativeLayout f36752b;

    /* renamed from: c, reason: collision with root package name */
    protected RelativeLayout f36753c;

    /* renamed from: d, reason: collision with root package name */
    protected ImageView f36754d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f36755e;

    /* renamed from: f, reason: collision with root package name */
    protected ProgressBar f36756f;

    /* renamed from: g, reason: collision with root package name */
    protected FrameLayout f36757g;

    /* renamed from: h, reason: collision with root package name */
    protected LinearLayout f36758h;

    /* renamed from: i, reason: collision with root package name */
    protected RelativeLayout f36759i;
    public a style;

    /* loaded from: classes5.dex */
    public enum a {
        FULL_TOP_VIEW,
        FULL_MIDDLE_VIEW
    }

    public BaseView(Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(g0.a(getContext(), "mbridge_nativex_fullbasescreen", TtmlNode.TAG_LAYOUT), this);
        this.f36759i = (RelativeLayout) inflate;
        if (inflate != null) {
            this.f36751a = (RelativeLayout) inflate.findViewById(g0.a(getContext(), "mbridge_full_rl_playcontainer", "id"));
            this.f36752b = (RelativeLayout) inflate.findViewById(g0.a(getContext(), "mbridge_full_player_parent", "id"));
            this.f36753c = (RelativeLayout) inflate.findViewById(g0.a(getContext(), "mbridge_full_rl_close", "id"));
            this.f36754d = (ImageView) inflate.findViewById(g0.a(getContext(), "mbridge_full_iv_close", "id"));
            this.f36755e = (TextView) inflate.findViewById(g0.a(getContext(), "mbridge_full_tv_install", "id"));
            this.f36756f = (ProgressBar) inflate.findViewById(g0.a(getContext(), "mbridge_full_pb_loading", "id"));
            this.f36757g = (FrameLayout) inflate.findViewById(g0.a(getContext(), "mbridge_full_animation_content", "id"));
            this.f36758h = (LinearLayout) inflate.findViewById(g0.a(getContext(), "mbridge_full_animation_player", "id"));
            inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public RelativeLayout getMBridgeFullClose() {
        return this.f36753c;
    }

    public ImageView getMBridgeFullIvClose() {
        return this.f36754d;
    }

    public ProgressBar getMBridgeFullPb() {
        return this.f36756f;
    }

    public RelativeLayout getMBridgeFullPlayContainer() {
        return this.f36751a;
    }

    public RelativeLayout getMBridgeFullPlayerParent() {
        return this.f36752b;
    }

    public TextView getMBridgeFullTvInstall() {
        return this.f36755e;
    }

    public a getStytle() {
        return this.style;
    }

    public FrameLayout getmAnimationContent() {
        return this.f36757g;
    }

    public LinearLayout getmAnimationPlayer() {
        return this.f36758h;
    }

    public void setStytle(a aVar) {
        this.style = aVar;
    }
}
