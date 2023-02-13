package vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Paging {
	private int currentPage;	// ���� ������
	private int totalCount; 	// ���� ��ü ����
	private int pageSize; 		// �Ѱ��������� ������ �� ����

	private int totalPage; 		// ��ü ������ ����

	private int startNo; 		// ȭ�鿡 ���δ� �۸���� ���� rownum
	private int endNo; 			// ȭ�鿡 ���δ� �۸���� ������ rownum

	private int startPage; 		// ȭ�鿡 ���̴� ����������� ����������
	private int endPage; 		// ȭ�鿡 ���̴� ����������� ������������ .

	// �����ڿ��� 3���� ���� �޾� ������ �ʵ尪�� ����մϴ�.
	public Paging(int currentPage, int totalCount, int pageSize) { // �ܺ�(�����Ͻ�����)���� �����ϰ� ���޵Ǵ°�.
		this.totalCount = totalCount;
		this.pageSize = pageSize;

		// ����
		// totalCount = 367���̴�. �׷���, pageSize=20 �� �� totalPage =19 , pageSize=10 �� ��
		// totalPage =37
		// totalCount = 7���̴�. �׷���, pageSize=20 �� �� totalPage =1 , pageSize=10 �� ��
		// totalPage =1
		// totalCount = 200���̴�. �׷���, pageSize=20 �� �� totalPage =10 , pageSize=10 �� ��
		// totalPage =20
		totalPage = (int) Math.ceil((double) totalCount / pageSize); // ceil �� �ø��Դϴ�.
		// ���������� ����(1~totalPage) �� ��ȿ���� üũ
		this.currentPage = (currentPage > totalPage) ? totalPage : currentPage;
		this.currentPage = (currentPage < 1) ? 1 : this.currentPage;

		// �� �κ��� ���� �����մϴ�. ���� ������ currentPage �� 1,2,3,4,5 ... ������� �����ؼ� ����غ�����.
		startNo = (this.currentPage - 1) * pageSize + 1;		// �� ��� �������ȣ(rownum)
		endNo = startNo + (pageSize - 1);

		// �Ʒ� ���ð��� ������ ������.
		startPage = (this.currentPage - 1) / 5 * 5 + 1; // ��������ȣ ����Ʈ 10����
		// ���� �������� 57 (51~60) , startPage =51
		// ���� �������� 7 (1~10) , startPage =1
		// ���� �������� 156 (151~160) , startPage =151
		// ���� �������� 160 (151~160) , startPage =151
		endPage = startPage + 4;
		endPage = endPage > totalPage ? totalPage : endPage; // totalPage ���� ū���� ���� ����.
	}
}