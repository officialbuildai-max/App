package com.transsion.transfer.wifi.permission;

import ak.x;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.activity.u;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.transfer.R$string;
import com.transsion.transfer.wifi.bean.PermissionState;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.g;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J/\u0010$\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0 2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/transsion/transfer/wifi/permission/PermissionsActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lgv/a;", "<init>", "()V", "", "I0", "M0", "J0", "Lcom/transsion/transfer/wifi/permission/PermissionsBean;", WebConstants.FIELD_ITEM, "L0", "(Lcom/transsion/transfer/wifi/permission/PermissionsBean;)V", "H0", "()Lgv/a;", "", "i0", "()Ljava/lang/String;", "", "q0", "()Z", "isTranslucent", "isStatusDark", "o0", "p0", "n0", "s0", "retryLoadData", "onDestroy", "onResume", "", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "", "i", "Ljava/util/List;", "mPermissionsList", "Lcom/transsion/transfer/wifi/permission/c;", j.f35620b, "Lcom/transsion/transfer/wifi/permission/c;", "permissionsListAdapter", CampaignEx.JSON_KEY_AD_K, "Ljava/lang/String;", "currentPermissions", "Transfer_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class PermissionsActivity extends BaseNewActivity<gv.a> {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private c permissionsListAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List mPermissionsList = new ArrayList();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String currentPermissions = "";

    /* loaded from: classes6.dex */
    public static final class a extends RecyclerView.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView f56026a;

        a(RecyclerView recyclerView) {
            this.f56026a = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            RecyclerView.Adapter adapter;
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (parent.getAdapter() != null) {
                RecyclerView recyclerView = this.f56026a;
                if (childAdapterPosition == 0 || ((adapter = recyclerView.getAdapter()) != null && adapter.getItemCount() == childAdapterPosition + 1)) {
                    outRect.top = a0.a(16.0f);
                } else {
                    outRect.top = a0.a(8.0f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends u {
        b() {
            super(true);
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            if (d.f56029a.g(PermissionsActivity.this.mPermissionsList)) {
                PermissionsActivity.this.setResult(-1);
            } else {
                PermissionsActivity.this.setResult(0);
            }
            PermissionsActivity.this.finish();
        }
    }

    private final void I0() {
        setResult(-1);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J0() {
        RecyclerView recyclerView = ((gv.a) getMViewBinding()).f64079c;
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(this));
        recyclerView.addItemDecoration(new a(recyclerView));
        c cVar = new c();
        cVar.w1(new p6.d() { // from class: com.transsion.transfer.wifi.permission.a
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                PermissionsActivity.K0(PermissionsActivity.this, baseQuickAdapter, view, i11);
            }
        });
        this.permissionsListAdapter = cVar;
        ((gv.a) getMViewBinding()).f64079c.setAdapter(this.permissionsListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(PermissionsActivity permissionsActivity, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = adapter.getItem(i11);
        if (item instanceof PermissionsBean) {
            permissionsActivity.L0((PermissionsBean) item);
        }
    }

    private final void L0(PermissionsBean item) {
        PermissionState state = item.getState();
        PermissionState permissionState = PermissionState.PERMISSION_REQUEST;
        if (state == permissionState || item.getState() == PermissionState.PERMISSION_GRANTED) {
            return;
        }
        kv.c cVar = kv.c.f68519a;
        Intent intent = getIntent();
        cVar.l(intent != null ? intent.getAction() : null, item.getPermission(), permissionState);
        this.currentPermissions = item.getPermission();
        if (!TextUtils.equals("mb.permission.WIFI", item.getPermission()) && ActivityCompat.j(this, item.getPermission())) {
            g.h(g.f56093a, getClassTag() + " --> itemClick() --> 如果是不再询问，那就直接跳转到设置页面", false, 2, null);
            d.f56029a.h(this);
            return;
        }
        String permission = item.getPermission();
        if (Intrinsics.c(permission, "mb.permission.WIFI")) {
            WifiUtils.f56083a.w(this);
            return;
        }
        if (Intrinsics.c(permission, "android.permission.WRITE_SETTINGS")) {
            WifiUtils.f56083a.v(this);
            return;
        }
        d dVar = d.f56029a;
        if (dVar.f(item.getPermission())) {
            return;
        }
        dVar.i(this, item.getPermission(), 101);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void M0() {
        /*
            r4 = this;
            android.content.Intent r0 = r4.getIntent()
            r1 = 0
            if (r0 == 0) goto Lc
            java.lang.String r0 = r0.getAction()
            goto Ld
        Lc:
            r0 = r1
        Ld:
            if (r0 == 0) goto L3d
            int r2 = r0.hashCode()
            r3 = -726963349(0xffffffffd4ab6b6b, float:-5.8899327E12)
            if (r2 == r3) goto L2d
            r3 = -616897536(0xffffffffdb3ae400, float:-5.2605034E16)
            if (r2 == r3) goto L1e
            goto L3d
        L1e:
            java.lang.String r2 = "com.transsion.transfer.wifi.util.send"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3d
            com.transsion.transfer.wifi.permission.d r0 = com.transsion.transfer.wifi.permission.d.f56029a
            java.util.List r0 = r0.e()
            goto L42
        L2d:
            java.lang.String r2 = "com.transsion.transfer.wifi.util.receive"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L36
            goto L3d
        L36:
            com.transsion.transfer.wifi.permission.d r0 = com.transsion.transfer.wifi.permission.d.f56029a
            java.util.List r0 = r0.c()
            goto L42
        L3d:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L42:
            r4.mPermissionsList = r0
            java.lang.String r0 = r4.currentPermissions
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L70
            com.transsion.transfer.wifi.permission.d r0 = com.transsion.transfer.wifi.permission.d.f56029a
            java.lang.String r2 = r4.currentPermissions
            boolean r0 = r0.f(r2)
            if (r0 == 0) goto L59
            com.transsion.transfer.wifi.bean.PermissionState r0 = com.transsion.transfer.wifi.bean.PermissionState.PERMISSION_GRANTED
            goto L5b
        L59:
            com.transsion.transfer.wifi.bean.PermissionState r0 = com.transsion.transfer.wifi.bean.PermissionState.PERMISSION_DENIED
        L5b:
            kv.c r2 = kv.c.f68519a
            android.content.Intent r3 = r4.getIntent()
            if (r3 == 0) goto L67
            java.lang.String r1 = r3.getAction()
        L67:
            java.lang.String r3 = r4.currentPermissions
            r2.l(r1, r3, r0)
            java.lang.String r0 = ""
            r4.currentPermissions = r0
        L70:
            com.transsion.transfer.wifi.permission.c r0 = r4.permissionsListAdapter
            if (r0 == 0) goto L7b
            java.util.List r1 = r4.mPermissionsList
            java.util.Collection r1 = (java.util.Collection) r1
            r0.n1(r1)
        L7b:
            java.util.List r0 = r4.mPermissionsList
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r1 = 1
        L84:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L9a
            java.lang.Object r2 = r0.next()
            com.transsion.transfer.wifi.permission.PermissionsBean r2 = (com.transsion.transfer.wifi.permission.PermissionsBean) r2
            com.transsion.transfer.wifi.bean.PermissionState r2 = r2.getState()
            com.transsion.transfer.wifi.bean.PermissionState r3 = com.transsion.transfer.wifi.bean.PermissionState.PERMISSION_DENIED
            if (r2 != r3) goto L84
            r1 = 0
            goto L84
        L9a:
            if (r1 == 0) goto L9f
            r4.I0()
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.wifi.permission.PermissionsActivity.M0():void");
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public gv.a getViewBinding() {
        gv.a c11 = gv.a.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String i0() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        return !x.f733a.a();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void n0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void o0() {
        TitleLayout titleLayout = ((gv.a) getMViewBinding()).f64080d;
        String string = getResources().getString(R$string.transfer_wifi_preparations);
        Intrinsics.g(string, "getString(...)");
        titleLayout.setTitleText(string);
        J0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        kv.c cVar = kv.c.f68519a;
        Intent intent = getIntent();
        cVar.m(intent != null ? intent.getAction() : null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if ((grantResults.length == 0) || grantResults[0] != 0) {
                return;
            }
            if (d.f56029a.g(this.mPermissionsList)) {
                I0();
            } else {
                setResult(0);
            }
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        M0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void p0() {
        getOnBackPressedDispatcher().i(this, new b());
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean q0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void s0() {
    }
}
