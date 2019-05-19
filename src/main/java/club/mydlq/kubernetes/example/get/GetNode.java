package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Node;
import io.kubernetes.client.models.V1NodeList;

/**
 * - 描述：获取 Node
 * - API版本： v1
 */
public class GetNode {

    /**
     * 获取 Kubernetes 集群的全部 Node 列表
     */
    public static void getAllNode() throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取全部 Node 列表
        V1NodeList nodeList = api.listNode(null, null, null, null, null, null, null, null, null);
        for (V1Node item : nodeList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取 Node 信息
     */
    public static void getNode(String nodeName) throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取全部 Node 列表
        V1Node node = api.readNode(nodeName, null, null, null);
        System.out.println(node);
    }

    /**
     * 获取 Node
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取 Kubernetes 集群的全部 Node
        getAllNode();
        // 获取 Kubernetes 集群的某个 Node 信息
        getNode("nodeName");
    }

}
