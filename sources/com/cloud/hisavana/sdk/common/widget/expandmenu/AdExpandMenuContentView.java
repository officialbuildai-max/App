package com.cloud.hisavana.sdk.common.widget.expandmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuItemView;

/* loaded from: classes3.dex */
public class AdExpandMenuContentView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f22318a;

    /* renamed from: b, reason: collision with root package name */
    private AdExpandMenuItemView f22319b;

    /* renamed from: c, reason: collision with root package name */
    private AdExpandMenuItemView f22320c;

    /* renamed from: d, reason: collision with root package name */
    private AdExpandMenuItemView f22321d;

    /* renamed from: e, reason: collision with root package name */
    private d f22322e;

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f22323a;

        a(d dVar) {
            this.f22323a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f22323a.a(AdExpandMenuItemView.Type.PERSONALISE_CLOSE);
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f22325a;

        b(d dVar) {
            this.f22325a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f22325a.a(AdExpandMenuItemView.Type.ADVERTISER_INFO);
        }
    }

    /* loaded from: classes3.dex */
    class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f22327a;

        c(d dVar) {
            this.f22327a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f22327a.a(AdExpandMenuItemView.Type.COPY_LINK);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(AdExpandMenuItemView.Type type);
    }

    public AdExpandMenuContentView(@NonNull Context context) {
        this(context, null, 0);
    }

    public AdExpandMenuContentView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdExpandMenuContentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R$layout.ad_expand_menu_content_layout, this);
        a();
    }

    private void a() {
        this.f22318a = (TextView) findViewById(R$id.advertiser_info);
        AdExpandMenuItemView adExpandMenuItemView = (AdExpandMenuItemView) findViewById(R$id.personalise);
        this.f22319b = adExpandMenuItemView;
        adExpandMenuItemView.setData(AdExpandMenuItemView.Type.PERSONALISE_CLOSE);
        AdExpandMenuItemView adExpandMenuItemView2 = (AdExpandMenuItemView) findViewById(R$id.about);
        this.f22320c = adExpandMenuItemView2;
        adExpandMenuItemView2.setData(AdExpandMenuItemView.Type.ADVERTISER_INFO);
        AdExpandMenuItemView adExpandMenuItemView3 = (AdExpandMenuItemView) findViewById(R$id.copy_link);
        this.f22321d = adExpandMenuItemView3;
        adExpandMenuItemView3.setData(AdExpandMenuItemView.Type.COPY_LINK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdvertiserName(String str) {
        this.f22318a.setText(str);
    }

    public void setListener(d dVar) {
        this.f22322e = dVar;
        this.f22319b.setOnClickListener(new a(dVar));
        this.f22320c.setOnClickListener(new b(dVar));
        this.f22321d.setOnClickListener(new c(dVar));
    }
}
