package jv;

import androidx.view.b0;
import java.util.LinkedList;
import kotlin.Unit;

/* loaded from: classes7.dex */
public final class b extends b0 {

    /* renamed from: l, reason: collision with root package name */
    private final LinkedList f66424l = new LinkedList();

    @Override // androidx.view.b0, androidx.view.LiveData
    public void n(Object obj) {
        synchronized (this.f66424l) {
            try {
                this.f66424l.add(obj);
                if (this.f66424l.size() == 1) {
                    super.n(obj);
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.view.b0, androidx.view.LiveData
    public void q(Object obj) {
        super.q(obj);
        synchronized (this.f66424l) {
            this.f66424l.pollFirst();
            Object peekFirst = this.f66424l.peekFirst();
            if (peekFirst != null) {
                super.n(peekFirst);
                Unit unit = Unit.f67184a;
            }
        }
    }
}
