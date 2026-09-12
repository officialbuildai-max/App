package m4;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final List f69304a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(u uVar) {
        this.f69304a.add(uVar);
    }

    public void b(Path path) {
        for (int size = this.f69304a.size() - 1; size >= 0; size--) {
            v4.l.b(path, (u) this.f69304a.get(size));
        }
    }
}
