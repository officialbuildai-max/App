package com.transsion.postdetail.layer;

import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.m;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.player.orplayer.g;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import lg.a;

/* loaded from: classes6.dex */
public abstract class BaseLayer {

    /* renamed from: a, reason: collision with root package name */
    private final String f48933a;

    /* renamed from: b, reason: collision with root package name */
    private g f48934b;

    /* renamed from: c, reason: collision with root package name */
    private String f48935c;

    /* renamed from: d, reason: collision with root package name */
    private PostSubjectItem f48936d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f48937e;

    /* renamed from: f, reason: collision with root package name */
    private ORPlayerView f48938f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f48939g;

    /* renamed from: h, reason: collision with root package name */
    private a f48940h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f48941i;

    public BaseLayer(final Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        this.f48933a = getClass().getSimpleName();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.layer.BaseLayer$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f48937e = FragmentViewModelLazyKt.a(fragment, Reflection.b(PostDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.layer.BaseLayer$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.layer.BaseLayer$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object invoke = Function0.this.invoke();
                m mVar = invoke instanceof m ? (m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public final void F(LayerFlag flag, Object... params) {
        Intrinsics.h(flag, "flag");
        Intrinsics.h(params, "params");
        a aVar = this.f48940h;
        if (aVar != null) {
            aVar.h(flag, Arrays.copyOf(params, params.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ImageView G() {
        return this.f48939g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final g H() {
        return this.f48934b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ORPlayerView I() {
        return this.f48938f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean J() {
        return this.f48941i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(ImageView imageView) {
        this.f48939g = imageView;
    }

    public final void L(a aVar) {
        this.f48940h = aVar;
    }

    public void M(g orPlayer, ORPlayerView orPlayerView) {
        Intrinsics.h(orPlayer, "orPlayer");
        Intrinsics.h(orPlayerView, "orPlayerView");
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f48933a;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "setPlayer----->", false, 4, null);
        this.f48934b = orPlayer;
        this.f48938f = orPlayerView;
    }

    public final void N(String postId, PostSubjectItem postSubjectItem) {
        Intrinsics.h(postId, "postId");
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f48933a;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "setPostData----->", false, 4, null);
        this.f48935c = postId;
        this.f48936d = postSubjectItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O(String str) {
        this.f48935c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P(boolean z10) {
        this.f48941i = z10;
    }
}
