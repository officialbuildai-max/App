package com.cloud.tmc.kernel.utils;

import com.cloud.tmc.kernel.extension.Extension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.node.NodeAware;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class NodeAwareUtils {
    public static final String TAG = "TmcKernel:ExtensionInvoker:Aware";

    public static void handleSetNode(Node node, Extension extension) {
        NodeAware nodeAware;
        Class nodeType;
        if (!(extension instanceof NodeAware) || (nodeType = (nodeAware = (NodeAware) extension).getNodeType()) == null) {
            return;
        }
        for (Node node2 = node; node2 != null; node2 = node2.getParentNode()) {
            if (nodeType.isAssignableFrom(node2.getClass())) {
                nodeAware.setNode(new WeakReference(node2));
                return;
            }
        }
        TmcLogger.w("TmcKernel:ExtensionInvoker:Aware", "cannot find Wanted node type: " + nodeType + " with target node: " + node + " in extension " + extension);
    }
}
