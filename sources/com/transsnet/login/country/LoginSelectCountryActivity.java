package com.transsnet.login.country;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.c0;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.KeyboardUtils;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.login.country.widget.SideBar;
import com.transsnet.loginapi.bean.Country;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import zy.i;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00072\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011H\u0002¢\u0006\u0004\b\u001f\u0010\u0015J\u0019\u0010 \u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b \u0010\fJ\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020#H\u0016¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020#H\u0016¢\u0006\u0004\b'\u0010%J\u0019\u0010*\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010-\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/transsnet/login/country/LoginSelectCountryActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lzy/i;", "Landroid/view/View$OnClickListener;", "Lcom/transsnet/login/country/widget/SideBar$a;", "<init>", "()V", "", "initView", "Landroid/os/Bundle;", "savedInstanceState", "k0", "(Landroid/os/Bundle;)V", "", RequestParameters.POSITION, "q0", "(Ljava/lang/Integer;)V", "", "", "strings", "u0", "(Ljava/util/List;)V", "Lxy/a;", "Lcom/transsnet/loginapi/bean/Country;", "countryEvent", "r0", "(Lxy/a;)V", PlaceTypes.COUNTRY, "s0", "(Lcom/transsnet/loginapi/bean/Country;)V", "countries", "t0", "onCreate", "j0", "()Lzy/i;", "", "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "Landroid/view/View;", "p0", "onClick", "(Landroid/view/View;)V", "index", be.g.f16474b, "(Ljava/lang/String;)V", "Lwy/a;", "a", "Lwy/a;", "adapter", "Lcom/transsnet/login/country/SelectCountryViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsnet/login/country/SelectCountryViewModel;", "viewModel", "Login_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class LoginSelectCountryActivity extends BaseActivity<i> implements View.OnClickListener, SideBar.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private wy.a adapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private SelectCountryViewModel viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f60409a;

        a(Function1 function) {
            Intrinsics.h(function, "function");
            this.f60409a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f60409a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f60409a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((i) getMViewBinding()).f79708e.setScrollerListener(this);
        ((i) getMViewBinding()).f79705b.setOnClickListener(this);
    }

    private final void k0(Bundle savedInstanceState) {
        SelectCountryViewModel selectCountryViewModel = (SelectCountryViewModel) new v0(this).a(SelectCountryViewModel.class);
        this.viewModel = selectCountryViewModel;
        if (selectCountryViewModel != null) {
            selectCountryViewModel.f().j(this, new a(new Function1() { // from class: com.transsnet.login.country.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit l02;
                    l02 = LoginSelectCountryActivity.l0(LoginSelectCountryActivity.this, (List) obj);
                    return l02;
                }
            }));
            selectCountryViewModel.k().j(this, new a(new Function1() { // from class: com.transsnet.login.country.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit m02;
                    m02 = LoginSelectCountryActivity.m0(LoginSelectCountryActivity.this, (List) obj);
                    return m02;
                }
            }));
            selectCountryViewModel.j().j(this, new a(new Function1() { // from class: com.transsnet.login.country.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit n02;
                    n02 = LoginSelectCountryActivity.n0(LoginSelectCountryActivity.this, (xy.a) obj);
                    return n02;
                }
            }));
            selectCountryViewModel.i().j(this, new a(new Function1() { // from class: com.transsnet.login.country.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit o02;
                    o02 = LoginSelectCountryActivity.o0(LoginSelectCountryActivity.this, (Integer) obj);
                    return o02;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(LoginSelectCountryActivity loginSelectCountryActivity, List list) {
        if (list != null) {
            loginSelectCountryActivity.t0(list);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(LoginSelectCountryActivity loginSelectCountryActivity, List list) {
        if (list != null) {
            loginSelectCountryActivity.u0(list);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(LoginSelectCountryActivity loginSelectCountryActivity, xy.a aVar) {
        loginSelectCountryActivity.r0(aVar);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(LoginSelectCountryActivity loginSelectCountryActivity, Integer num) {
        loginSelectCountryActivity.q0(num);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void p0(LoginSelectCountryActivity loginSelectCountryActivity) {
        KeyboardUtils.e(((i) loginSelectCountryActivity.getMViewBinding()).f79707d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q0(Integer position) {
        if (position != null) {
            ((i) getMViewBinding()).f79707d.scrollToPosition(position.intValue());
            RecyclerView.m layoutManager = ((i) getMViewBinding()).f79707d.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(position.intValue(), 0);
            }
        }
    }

    private final void r0(xy.a countryEvent) {
        if (countryEvent != null) {
            s0((Country) countryEvent.a());
        }
    }

    private final void s0(Country country) {
        if (country != null) {
            Intent intent = new Intent();
            intent.putExtra("countryCode", country);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t0(List countries) {
        wy.a aVar = this.adapter;
        if (aVar == null) {
            this.adapter = new wy.a(getApplicationContext(), this.viewModel, countries);
            ((i) getMViewBinding()).f79707d.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            ((i) getMViewBinding()).f79707d.setAdapter(this.adapter);
        } else if (aVar != null) {
            aVar.i(countries);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u0(List strings) {
        ((i) getMViewBinding()).f79708e.setIndexs(strings);
    }

    @Override // com.transsnet.login.country.widget.SideBar.a
    public void g(String index) {
        SelectCountryViewModel selectCountryViewModel;
        if (index == null || (selectCountryViewModel = this.viewModel) == null) {
            return;
        }
        selectCountryViewModel.q(index);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public i getViewBinding() {
        i c11 = i.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View p02) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        k0(savedInstanceState);
        KeyboardUtils.d(this);
        ((i) getMViewBinding()).f79707d.postDelayed(new Runnable() { // from class: com.transsnet.login.country.a
            @Override // java.lang.Runnable
            public final void run() {
                LoginSelectCountryActivity.p0(LoginSelectCountryActivity.this);
            }
        }, 200L);
    }
}
