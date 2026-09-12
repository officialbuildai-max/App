package androidx.compose.ui.platform;

import android.view.DragEvent;
import android.view.View;
import androidx.compose.ui.draganddrop.DragAndDropNode;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DragAndDropModifierOnDragListener implements View.OnDragListener, androidx.compose.ui.draganddrop.c {

    /* renamed from: a, reason: collision with root package name */
    private final Function3 f5708a;

    /* renamed from: b, reason: collision with root package name */
    private final DragAndDropNode f5709b = new DragAndDropNode(new Function1<androidx.compose.ui.draganddrop.b, androidx.compose.ui.draganddrop.f>() { // from class: androidx.compose.ui.platform.DragAndDropModifierOnDragListener$rootDragAndDropNode$1
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.draganddrop.f invoke(androidx.compose.ui.draganddrop.b bVar) {
            return null;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final androidx.collection.b f5710c = new androidx.collection.b(0, 1, null);

    /* renamed from: d, reason: collision with root package name */
    private final androidx.compose.ui.f f5711d = new androidx.compose.ui.node.l0() { // from class: androidx.compose.ui.platform.DragAndDropModifierOnDragListener$modifier$1
        public boolean equals(Object other) {
            return other == this;
        }

        public int hashCode() {
            DragAndDropNode dragAndDropNode;
            dragAndDropNode = DragAndDropModifierOnDragListener.this.f5709b;
            return dragAndDropNode.hashCode();
        }

        @Override // androidx.compose.ui.node.l0
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public DragAndDropNode a() {
            DragAndDropNode dragAndDropNode;
            dragAndDropNode = DragAndDropModifierOnDragListener.this.f5709b;
            return dragAndDropNode;
        }

        @Override // androidx.compose.ui.node.l0
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(DragAndDropNode node) {
        }
    };

    public DragAndDropModifierOnDragListener(Function3 function3) {
        this.f5708a = function3;
    }

    @Override // androidx.compose.ui.draganddrop.c
    public boolean a(androidx.compose.ui.draganddrop.d dVar) {
        return this.f5710c.contains(dVar);
    }

    @Override // androidx.compose.ui.draganddrop.c
    public void b(androidx.compose.ui.draganddrop.d dVar) {
        this.f5710c.add(dVar);
    }

    public androidx.compose.ui.f d() {
        return this.f5711d;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        androidx.compose.ui.draganddrop.b bVar = new androidx.compose.ui.draganddrop.b(dragEvent);
        switch (dragEvent.getAction()) {
            case 1:
                boolean D1 = this.f5709b.D1(bVar);
                Iterator<E> it = this.f5710c.iterator();
                while (it.hasNext()) {
                    ((androidx.compose.ui.draganddrop.d) it.next()).B(bVar);
                }
                return D1;
            case 2:
                this.f5709b.C(bVar);
                return false;
            case 3:
                return this.f5709b.k0(bVar);
            case 4:
                this.f5709b.Z0(bVar);
                return false;
            case 5:
                this.f5709b.a0(bVar);
                return false;
            case 6:
                this.f5709b.L(bVar);
                return false;
            default:
                return false;
        }
    }
}
