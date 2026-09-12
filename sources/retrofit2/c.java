package retrofit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c {

    /* loaded from: classes7.dex */
    static final class a extends c {
        @Override // retrofit2.c
        List a(Executor executor) {
            return Arrays.asList(new j(), new l(executor));
        }

        @Override // retrofit2.c
        List b() {
            return Collections.singletonList(new z());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List a(Executor executor) {
        return Collections.singletonList(new l(executor));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List b() {
        return Collections.emptyList();
    }
}
