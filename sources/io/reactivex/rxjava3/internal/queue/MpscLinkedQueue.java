package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.operators.f;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class MpscLinkedQueue implements f {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference f65594a = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference f65595b = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E e11) {
            spValue(e11);
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue(null);
            return lpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e11) {
            this.value = e11;
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        d(linkedQueueNode);
        e(linkedQueueNode);
    }

    LinkedQueueNode a() {
        return (LinkedQueueNode) this.f65595b.get();
    }

    LinkedQueueNode b() {
        return (LinkedQueueNode) this.f65595b.get();
    }

    LinkedQueueNode c() {
        return (LinkedQueueNode) this.f65594a.get();
    }

    @Override // io.reactivex.rxjava3.operators.g
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    void d(LinkedQueueNode linkedQueueNode) {
        this.f65595b.lazySet(linkedQueueNode);
    }

    LinkedQueueNode e(LinkedQueueNode linkedQueueNode) {
        return (LinkedQueueNode) this.f65594a.getAndSet(linkedQueueNode);
    }

    @Override // io.reactivex.rxjava3.operators.g
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // io.reactivex.rxjava3.operators.g
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode(obj);
        e(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.f, io.reactivex.rxjava3.operators.g
    public Object poll() {
        LinkedQueueNode lvNext;
        LinkedQueueNode a11 = a();
        LinkedQueueNode lvNext2 = a11.lvNext();
        if (lvNext2 != null) {
            Object andNullValue = lvNext2.getAndNullValue();
            d(lvNext2);
            return andNullValue;
        }
        if (a11 == c()) {
            return null;
        }
        do {
            lvNext = a11.lvNext();
        } while (lvNext == null);
        Object andNullValue2 = lvNext.getAndNullValue();
        d(lvNext);
        return andNullValue2;
    }
}
