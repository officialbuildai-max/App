package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class SemanticsPropertiesAndroid {

    /* renamed from: a, reason: collision with root package name */
    public static final SemanticsPropertiesAndroid f6020a = new SemanticsPropertiesAndroid();

    /* renamed from: b, reason: collision with root package name */
    private static final SemanticsPropertyKey f6021b = new SemanticsPropertyKey("TestTagsAsResourceId", false, new Function2<Boolean, Boolean, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesAndroid$TestTagsAsResourceId$1
        public final Boolean invoke(Boolean bool, boolean z10) {
            return bool;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((Boolean) obj, ((Boolean) obj2).booleanValue());
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public static final int f6022c = 8;

    private SemanticsPropertiesAndroid() {
    }

    public final SemanticsPropertyKey a() {
        return f6021b;
    }
}
