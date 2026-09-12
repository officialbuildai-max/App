package kotlinx.coroutines.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final LockFreeLinkedListNode f68008a;

    public t(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f68008a = lockFreeLinkedListNode;
    }

    public String toString() {
        return "Removed[" + this.f68008a + ']';
    }
}
