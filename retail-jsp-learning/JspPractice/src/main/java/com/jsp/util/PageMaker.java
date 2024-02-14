package com.jsp.util;

public class PageMaker {
	private Criteria criteria = null;	// 페이지안에 데이터를 담당할 객체(현재 페이지 번호, 데이터 양)
	
	private double totalDataCount; 		// 전체 게시글 수
	private boolean prev, next; 		// 앞으로, 뒤
	private int startPage, endPage; 	// 시작 페이지, 끝 페이지
	private int realEndPage;
	private int displayPageAmount;		

	public PageMaker() {
		criteria = new Criteria(1, 10);

		this.displayPageAmount = 5;	
		init();
	}

//	public PageMaker(double totalDataCount) {
//		this();
//		// 전체 데이터 갯수 -> next에 관련된 것
//		this.totalDataCount = totalDataCount;
//		init();
//	}

	public void init() {
		// 게시글 339, displayPageAmount 10, criterai, amount 10
		// case 1 startPage 1, endPage 10 : 1 ~ 100
		// case 2 startPage 11, endPage 20 : 101 ~ 200
		// case 3 startPage 21, endPage 30 : 201 ~ 300
		// case 4 startPage 31, endPage 40 : 301 ~ 400

		// endPage 계산
		// => endPage 34 : 301 ~ 340
		// pageNum = 8 -> amount: 71 ~ 80, startPage: 1, endPage: 10
		// pageNum = 12 -> amount: 111 ~ 120, startPage: 11, endPage: 20
		// pageNum = 32 -> amount: 311 ~ 320, startPage: 31, endPage: 34
		// pageNum = 34 -> amount: 311 ~ 339, startPage: 31, endPage: 34

		endPage = (int) (Math.ceil(this.criteria.getPageNum() * 1.0 / displayPageAmount) * displayPageAmount);

		// RealEndPage 계산
		// cri.amount = 10, -> 339 / 10 = 33.9 올림(ceil) 34
		realEndPage = (int) (Math.ceil(this.getTotalDataCount() / (double) this.criteria.getAmount()));

		// startPage 계산
		// pageNum = 8, endPage = 10, startPage = 1, displayAmount = 10
		// (10) - (10 - 1)
		// * endPage - (displayAMount - 1) -> 10 - (10 - 1) = 1, startPage = 1
		// pageNum = 12, endPage = 20, startPage = 11,
		// pageNum = 32, endPage = 40, startPage = 31
		startPage = endPage - (displayPageAmount - 1);

		// endPage, realEndPage 계산
		// pageNum = 8, endPage = 10, realEndPage = 34
		// pageNum= 12, endPage = 20, realEndPage = 34
		// pageNum = 32, endPage = 40, realEndPage = 34 -> endPage = 34

		if (realEndPage < endPage) {
			endPage = realEndPage;
		}
		
		// prev 1 2 3 4 5 ~ 10 next

		// pageNum = 8, startPage > 1
		// prev(false) 1 2 3 4 5 ~ 10 next(true)
		
		// pageNum = 12
		// prev(true) 11 12 13 14 15 ~ 20 next(true)
		
		// pageNum = 32
		// prev(true) 31 32 33 34 next(false)
		
		// pageNum = 8		-> prev = false, startPage = 1, endPage = 10, realEndPage = 34, next = true
		// pageNum = 12		-> prev = true, startPage = 11, endPage = 20, realEndPage = 34, next = true
		// pageNum = 32		-> prev = true, startPage = 31, endPage = 34, realEndPage = 34, next = false
		prev = startPage > 1 && startPage > displayPageAmount;
		next = endPage < realEndPage;
		
		// totalCount -> pageNum 보정
		
	}
	
	public static PageMaker getPageMaker(int pageNum) {
		return getPageMaker(pageNum, 0);
	}
	
	public static PageMaker getPageMaker(int pageNum, double totalDataCount) {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setTotalDataCount(totalDataCount);
		
		// "?pageNo=123123"
		if(totalDataCount != 0) {
			if(pageNum <= 0) {
				pageNum = 1;
			} else if(pageMaker.getRealEndPage() < pageNum){
				pageNum = 1;
			}	
		}
		
		pageMaker.setCriteriaPageNum(pageNum);
		
		return pageMaker;
	}

//	private void calculatePageNum() {
//		if(totalDataCount != 0) {
//			if(this.criteria.pageNum <= 0) {
//				this.criteria.pageNum = 1;
//			} else if(getRealEndPage() < this.criteria.pageNum){
//				this.criteria.pageNum = 1;
//			}	
//		}
//	}
	
	public double getTotalDataCount() {
		return totalDataCount;
	}

	public void setTotalDataCount(double totalDataCount) {
		this.totalDataCount = totalDataCount;
		init();
		// calculatePageNum();
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}

	public int getDisplayPageAmount() {
		return displayPageAmount;
	}

	public void setDisplayPageAmount(int displayPageAmount) {
		this.displayPageAmount = displayPageAmount;
		init();
	}

	public Criteria getCriteria() {
		return this.criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
		init();
	}

	public int getCriteriaPageNum() {
		return this.criteria.getPageNum();
	}

	public void setCriteriaPageNum(int pageNum) {
		this.criteria.setPageNum(pageNum);
		init();
	}

	public int getCriteriaAmount() {
		return this.criteria.getAmount();
	}

	public void setCriteriaAmount(int amount) {
		this.criteria.setAmount(amount);
		init();
	}

	private class Criteria {
		private int pageNum; 	// 내가 클릭한 페이지 번호
		private int amount; 	// 테이블에 몇개씩 나타낼지

		private Criteria(int pageNum, int amount) {
			this.pageNum = pageNum;
			this.amount = amount;
		}

		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

	}

	public static void main(String[] args) {
		// pageNum = 8		-> prev = false, startPage = 1, endPage = 10, realEndPage = 34, next = true
		// pageNum = 12		-> prev = true, startPage = 11, endPage = 20, realEndPage = 34, next = true
		// pageNum = 32		-> prev = true, startPage = 31, endPage = 34, realEndPage = 34, next = false
		
		int pageNum = 8;
		int totalCount = 333;
		int displayPageAmount = 5; 	// 5개씩 

		PageMaker pageMaker = new PageMaker();

		pageMaker.setDisplayPageAmount(displayPageAmount);
		
		pageMaker.setTotalDataCount(totalCount);
		pageMaker.setCriteriaPageNum(pageNum);
		printPageNation(pageMaker);

		pageNum = 12;
		pageMaker.setCriteriaPageNum(pageNum);
		printPageNation(pageMaker);

		pageNum = 32;
		pageMaker.setCriteriaPageNum(pageNum);
		printPageNation(pageMaker);
	}

	public static void printPageNation(PageMaker pageMaker) {
		String sentence = "pageNum = " + pageMaker.getCriteriaPageNum() + " -> prev: " + pageMaker.isPrev() + ", startPage: " + pageMaker.getStartPage()
				+ ", endPage: " + pageMaker.getEndPage() + ", realEndPage: " + pageMaker.getRealEndPage() + ", next: " + pageMaker.isNext();
		System.out.println(sentence);
	}	
}
