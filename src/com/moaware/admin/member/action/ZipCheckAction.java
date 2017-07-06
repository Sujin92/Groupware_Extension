package com.moaware.admin.member.action;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
	
public class ZipCheckAction {
	//* ��������Ÿ����(http://www.data.go.kr) ���� API �̿�
	    
	// ���񽺸� : ���հ˻� 5�ڸ� �����ȣ ��ȸ����
	// �� �����ȣ(2015-08-01����) ���� API �ּ�
	// http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdSearchAllService/retrieveNewAdressAreaCdSearchAllService/getNewAddressListAreaCdSearchAll
	    
	// [in] s : �˻��� (���θ��ּ�[���θ�/�ǹ���] �Ǵ� �����ּ�[��/��/��/��])
	// [in] p : �о�� ������(1����), l : �� �������� ����� ��� ��(�ִ� 50����)
	// [out] v[i*3 +0]=�����ȣ, v[i*3 +1]=���θ��ּ�, v[i*3 +2]=�����ּ�, v.Count/3=ǥ���� ��� ��
	// [out] n[0]=�˻��� ��ü ���(�����ȣ) ����, n[1]=�о�� ������(1����)
	// ��ȯ�� : �����޽���, null == OK
	public static String find(String s, int p, int l, List<String> v, int[] n) {
		HttpURLConnection con = null;
	        
		try {
			URL url = new URL("http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdSearchAllService/retrieveNewAdressAreaCdSearchAllService/getNewAddressListAreaCdSearchAll"
					+ "?ServiceKey=ICNoCDBt1v9FoTvJhcpK3OHPx0HI5DZGZiHBVS9qppXzA28jduVTgUHzeRM15rW3zIVsyS%2FDv3duteIO7edvwA%3D%3D" // ����Ű
					+ "&countPerPage=" + l // �������� ��µ� ������ ����(�ִ� 50)
					+ "&currentPage=" + p // ��µ� ������ ��ȣ
					+ "&srchwrd=" + URLEncoder.encode(s,"UTF-8")); // �˻���
					
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Accept-language", "ko");
	            
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder bd = fac.newDocumentBuilder();
			Document doc = bd.parse(con.getInputStream());
	            
			boolean bOk = false; // <successYN>Y</successYN> ȹ�� ����
			s = null; // ���� �޽���
	            
			String nn;
			Node nd;
			NodeList ns = doc.getElementsByTagName("cmmMsgHeader");
			if (ns.getLength() > 0)
				for (nd = ns.item(0).getFirstChild(); nd != null; nd = nd.getNextSibling()) {
					nn = nd.getNodeName();
	                
					if (!bOk) {
						if (nn.equals("successYN")) { // ���� ����
							if (nd.getTextContent().equals("Y")) bOk = true; // �˻� ����
						} else if (nn.equals("errMsg")) { // ���� �޽���
							s = nd.getTextContent();
						}
					} else {
						if (nn.equals("totalCount")) { // ��ü �˻���
							n[0] = Integer.parseInt(nd.getTextContent());
						} else if (nn.equals("currentPage")) { // ���� ������ ��ȣ
							n[1] = Integer.parseInt(nd.getTextContent());
						}
					}
				}
	            
			if (bOk) {
				ns = doc.getElementsByTagName("newAddressListAreaCdSearchAll");
				for (p = 0; p < ns.getLength(); p++)
					for (nd = ns.item(p).getFirstChild(); nd != null; nd = nd.getNextSibling()) {
						// nn = nd.getNodeName();
						// if (nn.equals("zipNo") || // �����ȣ
						//  nn.equals("lnmAdres") || // ���θ� �ּ�
						//  nn.equals("rnAdres")) // ���� �ּ�
						// {
						v.add(nd.getTextContent());
						// }
					}
			}
	            
			if (s == null) { // OK!
				if (v.size() < 3)
					s = "�˻������ �����ϴ�.";
			}
		} catch(Exception e) {
			s = e.getMessage();
		}
	        
		if (con != null)
			con.disconnect();
		return s;
	}
}
