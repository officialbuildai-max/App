package androidx.compose.runtime.saveable;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public interface b {

    /* loaded from: classes.dex */
    public interface a {
        void unregister();
    }

    boolean a(Object obj);

    a b(String str, Function0 function0);

    Map e();

    Object f(String str);
}
