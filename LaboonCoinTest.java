import static org.junit.Assert.*;

import org.junit.*;

public class LaboonCoinTest 
{

    // Assert that creating a new LaboonCoin instance
    // does not return a null reference
    @Test
    public void testLaboonCoinExists() 
	{
	LaboonCoin l = new LaboonCoin();
	assertNotNull(l);
    }
	
	//Assert Hash() in LaboonCoin works properly
	//tests boo as shown in guidelines
	@Test
    public void testHash() 
	{
	LaboonCoin l = new LaboonCoin();
		int hash = l.hash("boo");
		int result = 1428150834;
		assertEquals(result, hash);
    }
	
	//Assert ValidHash() in LaboonCoin works properly for max difficulty edge case
	@Test
    public void testValidHashMax() 
	{
	LaboonCoin l = new LaboonCoin();
	boolean result = l.validHash(8,0);
	assertEquals(result, true);
    }
	
	//Assert ValidHash() in LaboonCoin works properly for zero difficulty edge case
	@Test
    public void testValidHashZero() 
	{
	LaboonCoin l = new LaboonCoin();
	boolean result = l.validHash(0,8);
	assertEquals(result, true);
    }
	
	 @Test
	 //Assert CreateBlock() in LaboonCoin works properly
    public void testCreateBlock() 
	{
  LaboonCoin l = new LaboonCoin();
  String result = l.createBlock("hiworld", 1, 2, 3);
  assertEquals(result, "hiworld|00000001|00000002|00000003");
    }
	
	@Test
	//Assert corner case that hash remains unchanged with an empty hash value
	public void testEmptyHash()
	{
		LaboonCoin l = new LaboonCoin();
		assertEquals(l.hash(""), 10000000);
	}
    
	@Test
	//Assert getblockchain in labooncoin is not null
	public void testBlockChainExists()
	{
		LaboonCoin l = new LaboonCoin();
		assertNotNull(l.blockchain);
	}
	
	@Test
	//Assert getblockchain can return an empty chain
	public void testEmptyPrint()
	{
		LaboonCoin l = new LaboonCoin();
		assertEquals(l.getBlockChain(), "");
	}
	
	//Assert validHash works properly for lesser difficulty case
	@Test
	public void testLessDifficulty()
	{
		LaboonCoin l = new LaboonCoin();
		assertTrue(l.validHash(5, 212));	
	}
	
	//Assert validHash works properly for higher difficulty case
	@Test
	public void testHigherDifficulty()
	{
	
		LaboonCoin l = new LaboonCoin();
		assertTrue(l.validHash(1, 16619695));	
			
	}
	
	//	Assert the happy path of a nonempty blockchain
	@Test
	//getting errors recognizing labooncoin so i used 'one'
	public void testHappyBlockPrint()
	{
		LaboonCoin one = new LaboonCoin();
		one.blockchain.add("All your base");
		one.blockchain.add("are belong");
		one.blockchain.add("to us");
		assertEquals("All your base" + '\n' + "are belong" + '\n'  + "to us" + '\n', one.getBlockChain());
	}
	
	 @Test
	 //Assert CreateBlock() with initial empty string in LaboonCoin works properly
    public void testCreateEmptyBlock() 
	{
	LaboonCoin l = new LaboonCoin();
	String result = l.createBlock("", 1, 2, 3);
	assertEquals(result, "|00000001|00000002|00000003");
    }
	
	  
     //Assert that  block chains with multiple plocks are correctly output.
     
    @Test
    public void testGetBlockChainLength3() 
	{
	    LaboonCoin test = new LaboonCoin();
        test.blockchain.add("how|00000000|00001111|01010101");
        test.blockchain.add("to|22222222|22220000|12121212");
        test.blockchain.add("laboon|22222222|22220000|12121212");
	    assertEquals("how|00000000|00001111|01010101\nto|22222222|22220000|12121212\nlaboon|22222222|22220000|12121212\n", test.getBlockChain());
		}
}