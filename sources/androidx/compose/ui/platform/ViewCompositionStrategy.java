package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public interface ViewCompositionStrategy {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5756a = a.f5759a;

    /* loaded from: classes.dex */
    public static final class DisposeOnDetachedFromWindowOrReleasedFromPool implements ViewCompositionStrategy {

        /* renamed from: b, reason: collision with root package name */
        public static final DisposeOnDetachedFromWindowOrReleasedFromPool f5757b = new DisposeOnDetachedFromWindowOrReleasedFromPool();

        /* loaded from: classes.dex */
        public static final class a implements View.OnAttachStateChangeListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AbstractComposeView f5758a;

            a(AbstractComposeView abstractComposeView) {
                this.f5758a = abstractComposeView;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (h1.a.f(this.f5758a)) {
                    return;
                }
                this.f5758a.disposeComposition();
            }
        }

        private DisposeOnDetachedFromWindowOrReleasedFromPool() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(AbstractComposeView abstractComposeView) {
            abstractComposeView.disposeComposition();
        }

        @Override // androidx.compose.ui.platform.ViewCompositionStrategy
        public Function0 a(final AbstractComposeView abstractComposeView) {
            final a aVar = new a(abstractComposeView);
            abstractComposeView.addOnAttachStateChangeListener(aVar);
            final h1.b bVar = new h1.b() { // from class: androidx.compose.ui.platform.m2
                @Override // h1.b
                public final void onRelease() {
                    ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.c(AbstractComposeView.this);
                }
            };
            h1.a.a(abstractComposeView, bVar);
            return new Function0<Unit>() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m162invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m162invoke() {
                    AbstractComposeView.this.removeOnAttachStateChangeListener(aVar);
                    h1.a.g(AbstractComposeView.this, bVar);
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f5759a = new a();

        private a() {
        }

        public final ViewCompositionStrategy a() {
            return DisposeOnDetachedFromWindowOrReleasedFromPool.f5757b;
        }
    }

    Function0 a(AbstractComposeView abstractComposeView);
}
