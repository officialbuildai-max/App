package com.mbridge.msdk.nativex.view.mbfullview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes5.dex */
public class MBridgeTopFullView extends BaseView {
    public static final String INTERFACE_RESULT = MBridgeTopFullView.class.getName() + "WithResault";

    /* renamed from: j, reason: collision with root package name */
    protected ImageView f36763j;

    /* renamed from: k, reason: collision with root package name */
    protected TextView f36764k;

    /* renamed from: l, reason: collision with root package name */
    protected TextView f36765l;

    /* renamed from: m, reason: collision with root package name */
    protected StarLevelLayoutView f36766m;

    public MBridgeTopFullView(Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(g0.a(getContext(), "mbridge_nativex_fullscreen_top", TtmlNode.TAG_LAYOUT), this.f36759i);
        if (inflate != null) {
            this.f36763j = (ImageView) inflate.findViewById(g0.a(getContext(), "mbridge_full_tv_display_icon", "id"));
            this.f36764k = (TextView) inflate.findViewById(g0.a(getContext(), "mbridge_full_tv_display_title", "id"));
            this.f36765l = (TextView) inflate.findViewById(g0.a(getContext(), "mbridge_full_tv_display_description", "id"));
            this.f36766m = (StarLevelLayoutView) inflate.findViewById(g0.a(getContext(), "mbridge_full_tv_feeds_star", "id"));
            this.f36765l.setTextColor(-7829368);
            inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            updateLayoutParams();
        }
    }

    public TextView getMBridgeFullViewDisplayDscription() {
        return this.f36765l;
    }

    public ImageView getMBridgeFullViewDisplayIcon() {
        return this.f36763j;
    }

    public TextView getMBridgeFullViewDisplayTitle() {
        return this.f36764k;
    }

    public StarLevelLayoutView getStarLevelLayoutView() {
        return this.f36766m;
    }

    public void updateLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        this.f36751a.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(10);
        this.f36752b.setLayoutParams(layoutParams2);
    }
}
