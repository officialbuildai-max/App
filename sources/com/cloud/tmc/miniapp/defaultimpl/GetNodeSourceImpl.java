package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.PageContext;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.IGetNodeSource;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.miniapp.ui.MiniFragment;
import com.cloud.tmc.miniapp.ui.MiniH5Fragment;
import com.cloud.tmc.miniapp.ui.MiniShellFragment;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class GetNodeSourceImpl implements IGetNodeSource {
    @Override // com.cloud.tmc.kernel.node.IGetNodeSource
    public String getNodeSource(Node node) {
        Intrinsics.h(node, "node");
        try {
            if (node instanceof Page) {
                PageContext pageContext = ((Page) node).getPageContext();
                return pageContext instanceof MiniFragment ? TmcConstants.PAGE_NORMAL : pageContext instanceof MiniH5Fragment ? TmcConstants.PAGE_H5_SHELL : pageContext instanceof MiniShellFragment ? TmcConstants.PAGE_MINI_SHELL : TmcConstants.PAGE_OTHER;
            }
        } catch (Throwable th2) {
            TmcLogger.e(TmcConstants.TAG, th2.getMessage(), th2);
        }
        return TmcConstants.PAGE_OTHER;
    }
}
