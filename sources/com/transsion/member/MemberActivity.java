package com.transsion.member;

import androidx.fragment.app.FragmentManager;
import com.cloud.tmc.integration.event.EventConstants;
import com.therouter.TheRouter;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.member.MemberActivity;
import com.transsion.member.MemberPremiumFragment;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.memberapi.SkuPromotionItem;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\b\u0007*\u0001\u0015\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/transsion/member/MemberActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lwm/a;", "<init>", "()V", "", "G0", "H0", "()Lwm/a;", "", "i0", "()Ljava/lang/String;", "o0", "", "isTranslucent", "()Z", "r0", "p0", "n0", "s0", "retryLoadData", "com/transsion/member/MemberActivity$b", "i", "Lcom/transsion/member/MemberActivity$b;", "onBackPress", com.mbridge.msdk.foundation.same.report.j.f35620b, "a", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class MemberActivity extends BaseNewActivity<wm.a> {

    /* renamed from: j, reason: collision with root package name */
    private static final a f46340j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    public static final int f46341k = 8;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final b onBackPress = new b();

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends androidx.activity.u {
        b() {
            super(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(SkuPromotionItem it) {
            Intrinsics.h(it, "it");
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(MemberActivity memberActivity) {
            memberActivity.G0();
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit i(MemberActivity memberActivity, Throwable it) {
            Intrinsics.h(it, "it");
            a.C0856a.l(lg.a.f68962a, "premium_discount", "MemberActivity --> onBackPress --> onLoadFailed{} --> " + it.getMessage(), false, 4, null);
            memberActivity.G0();
            return Unit.f67184a;
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            IPremiumApi iPremiumApi;
            com.transsion.member.a.f46460a.a("MemberActivity --> onBackPress --> handleOnBackPressed()");
            IPremiumApi iPremiumApi2 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
            if (iPremiumApi2 != null ? iPremiumApi2.c() : false) {
                MemberActivity.this.G0();
                return;
            }
            if (MemberActivity.this.getSupportFragmentManager().k0("member_retention_dialog") != null || (iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0])) == null) {
                return;
            }
            MemberActivity memberActivity = MemberActivity.this;
            Function1 function1 = new Function1() { // from class: com.transsion.member.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit g11;
                    g11 = MemberActivity.b.g((SkuPromotionItem) obj);
                    return g11;
                }
            };
            final MemberActivity memberActivity2 = MemberActivity.this;
            Function0 function0 = new Function0() { // from class: com.transsion.member.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit h11;
                    h11 = MemberActivity.b.h(MemberActivity.this);
                    return h11;
                }
            };
            final MemberActivity memberActivity3 = MemberActivity.this;
            iPremiumApi.l(memberActivity, function1, function0, new Function1() { // from class: com.transsion.member.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit i11;
                    i11 = MemberActivity.b.i(MemberActivity.this, (Throwable) obj);
                    return i11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0() {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null ? iMemberApi.c() : false) {
            setResult(-1);
        } else {
            setResult(0);
        }
        finish();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public wm.a getViewBinding() {
        wm.a c11 = wm.a.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String i0() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void n0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void o0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        androidx.fragment.app.w p11 = supportFragmentManager.p();
        Intrinsics.g(p11, "beginTransaction()");
        p11.t(R$id.flContent, MemberPremiumFragment.Companion.b(MemberPremiumFragment.INSTANCE, getIntent().getStringExtra(EventConstants.KEY_SOURCE), getIntent().getStringExtra("scene_id"), getIntent().getStringExtra("trace_id"), null, 8, null), "MemberFragment");
        p11.j();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void p0() {
        getOnBackPressedDispatcher().i(this, this.onBackPress);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean r0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void s0() {
    }
}
