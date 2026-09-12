package com.mbridge.msdk.video.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.mbridge.msdk.foundation.tools.g0;

/* loaded from: classes5.dex */
public class MBridgeVastEndCardView extends MBridgeBaseView {

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f39395m;

    /* renamed from: n, reason: collision with root package name */
    private View f39396n;

    /* renamed from: o, reason: collision with root package name */
    private View f39397o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVastEndCardView.this.notifyListener.a(104, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends com.mbridge.msdk.widget.a {
        b() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            MBridgeVastEndCardView mBridgeVastEndCardView = MBridgeVastEndCardView.this;
            mBridgeVastEndCardView.notifyListener.a(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, mBridgeVastEndCardView.c());
        }
    }

    public MBridgeVastEndCardView(Context context) {
        super(context);
    }

    public MBridgeVastEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean e() {
        this.f39395m = (ViewGroup) findViewById(findID("mbridge_rl_content"));
        this.f39396n = findViewById(findID("mbridge_iv_vastclose"));
        View findViewById = findViewById(findID("mbridge_iv_vastok"));
        this.f39397o = findViewById;
        return isNotNULL(this.f39395m, this.f39396n, findViewById);
    }

    private void f() {
        if (this.f39283e) {
            setMatchParent();
            setBackgroundResource(findColor("mbridge_reward_endcard_vast_bg"));
            setClickable(true);
            ((RelativeLayout.LayoutParams) this.f39395m.getLayoutParams()).addRule(13, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void d() {
        super.d();
        if (this.f39283e) {
            this.f39396n.setOnClickListener(new a());
            this.f39397o.setOnClickListener(new b());
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_endcard_vast");
        if (g0.a(findLayout)) {
            this.f39281c.inflate(findLayout, this);
            this.f39283e = e();
            d();
            f();
        }
    }

    public void notifyShowListener() {
        this.notifyListener.a(111, "");
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
    }
}
