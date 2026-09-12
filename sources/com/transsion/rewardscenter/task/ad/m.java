package com.transsion.rewardscenter.task.ad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.task.ad.v;
import com.transsion.rewardscenterapi.MemberTaskItem;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class m extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final MemberTaskAdHelper f51155e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f51156f;

    /* renamed from: g, reason: collision with root package name */
    private int f51157g;

    /* renamed from: h, reason: collision with root package name */
    private int f51158h;

    /* renamed from: i, reason: collision with root package name */
    private int f51159i;

    /* renamed from: j, reason: collision with root package name */
    private final int f51160j = AdTaskType.REGULAR_AD.getValue();

    /* renamed from: k, reason: collision with root package name */
    private final int f51161k = R$layout.member_task_regular_item_layout;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51162a;

        static {
            int[] iArr = new int[AdTaskState.values().length];
            try {
                iArr[AdTaskState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdTaskState.INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AdTaskState.PLAYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AdTaskState.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AdTaskState.NORMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AdTaskState.PLAYING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f51162a = iArr;
        }
    }

    public m(MemberTaskAdHelper memberTaskAdHelper) {
        this.f51155e = memberTaskAdHelper;
    }

    private final void C(v.a aVar) {
        NativeWrapperAdView h11 = aVar.h();
        if (h11 != null) {
            NativeWrapperAdView.simulatingClick$default(h11, aVar.c(), null, aVar.j(), 2, null);
        }
    }

    private final void D(v.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "member_ad_task_regular");
        hashMap.put("ad_state", aVar.e().name());
        hashMap.put("pull_new", String.valueOf(aVar.k()));
        hj.i.f64628a.p("MemberAdTask", hashMap);
    }

    private final void E() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "member_ad_task_regular");
        hj.i.f64628a.D("MemberAdTask", hashMap);
    }

    private final void F(BaseViewHolder baseViewHolder, v.a aVar) {
        FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(R$id.ad_container);
        MemberTaskAdHelper memberTaskAdHelper = this.f51155e;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.Q(aVar);
        }
        NativeWrapperAdView h11 = aVar.h();
        if (h11 != null) {
            ViewParent parent = h11.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(h11);
            }
            frameLayout.removeAllViews();
            frameLayout.addView(h11);
        }
    }

    private final void G(v.a aVar) {
        u.f51176a.v(aVar.i(), aVar.e());
    }

    private final void H(BaseViewHolder baseViewHolder, v.a aVar, boolean z10) {
        TextView textView = (TextView) baseViewHolder.getView(R$id.btn_action);
        int i11 = a.f51162a[aVar.e().ordinal()];
        if (i11 == 1) {
            textView.setText("Downloading...");
            textView.setTextColor(this.f51158h);
            return;
        }
        if (i11 == 2 || i11 == 3) {
            textView.setText("Claim");
            textView.setTextColor(this.f51157g);
        } else if (i11 != 4) {
            textView.setText(z10 ? "Install" : "Open");
            textView.setTextColor(this.f51157g);
        } else {
            textView.setText("Completed");
            textView.setTextColor(this.f51159i);
        }
    }

    static /* synthetic */ void I(m mVar, BaseViewHolder baseViewHolder, v.a aVar, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        mVar.H(baseViewHolder, aVar, z10);
    }

    private final void J(final BaseViewHolder baseViewHolder, final v.a aVar, final boolean z10) {
        jg.c.c((TextView) baseViewHolder.getView(R$id.btn_action), 0L, new Function1() { // from class: com.transsion.rewardscenter.task.ad.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K;
                K = m.K(m.this, aVar, z10, baseViewHolder, (View) obj);
                return K;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(final m mVar, final v.a aVar, boolean z10, final BaseViewHolder baseViewHolder, View it) {
        Intrinsics.h(it, "it");
        mVar.D(aVar);
        int i11 = a.f51162a[aVar.e().ordinal()];
        if (i11 == 2) {
            MemberTaskAdHelper memberTaskAdHelper = mVar.f51155e;
            if (memberTaskAdHelper != null) {
                memberTaskAdHelper.z(aVar, new Function0() { // from class: com.transsion.rewardscenter.task.ad.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit L;
                        L = m.L(v.a.this, mVar, baseViewHolder);
                        return L;
                    }
                });
            }
        } else if (i11 == 3) {
            MemberTaskAdHelper memberTaskAdHelper2 = mVar.f51155e;
            if (memberTaskAdHelper2 != null) {
                memberTaskAdHelper2.z(aVar, new Function0() { // from class: com.transsion.rewardscenter.task.ad.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit M;
                        M = m.M(v.a.this, mVar, baseViewHolder);
                        return M;
                    }
                });
            }
        } else if (i11 == 5) {
            if (z10) {
                aVar.m(AdTaskState.DOWNLOADING);
                aVar.o(System.currentTimeMillis());
            } else {
                aVar.m(AdTaskState.PLAYING);
            }
            I(mVar, baseViewHolder, aVar, false, 4, null);
            mVar.G(aVar);
            mVar.C(aVar);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(v.a aVar, m mVar, BaseViewHolder baseViewHolder) {
        aVar.m(AdTaskState.COMPLETED);
        I(mVar, baseViewHolder, aVar, false, 4, null);
        mVar.G(aVar);
        mVar.f51155e.y(aVar.i(), Integer.valueOf(mVar.f51155e.q(aVar.c().getSceneId())));
        u.f51176a.q(aVar);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(v.a aVar, m mVar, BaseViewHolder baseViewHolder) {
        aVar.m(AdTaskState.COMPLETED);
        I(mVar, baseViewHolder, aVar, false, 4, null);
        mVar.G(aVar);
        return Unit.f67184a;
    }

    private final void N(BaseViewHolder baseViewHolder, boolean z10) {
        TextView textView = (TextView) baseViewHolder.getView(R$id.member_point);
        if (z10) {
            MemberTaskItem h11 = u.f51176a.h();
            textView.setText("+" + (h11 != null ? h11.getRewardAmount() : null) + " points");
            return;
        }
        MemberTaskItem g11 = u.f51176a.g();
        textView.setText("+" + (g11 != null ? g11.getRewardAmount() : null) + " points");
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, v item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        if (item instanceof v.a) {
            v.a aVar = (v.a) item;
            F(helper, aVar);
            boolean k11 = aVar.k();
            N(helper, k11);
            if (!k11 && aVar.e() == AdTaskState.COMPLETED) {
                aVar.m(AdTaskState.NORMAL);
            }
            H(helper, aVar, k11);
            J(helper, aVar, k11);
            if (this.f51156f) {
                return;
            }
            this.f51156f = true;
            E();
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f51160j;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f51161k;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder r(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(m(), parent, false);
        this.f51157g = androidx.core.content.b.getColor(parent.getContext(), R$color.white);
        this.f51158h = androidx.core.content.b.getColor(parent.getContext(), R$color.white_50);
        this.f51159i = androidx.core.content.b.getColor(parent.getContext(), R$color.white_40);
        Intrinsics.e(inflate);
        return new BaseViewHolder(inflate);
    }
}
