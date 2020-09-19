 ## Tasking
 # 存包
```

   * Given XiaoYing manages LockerA, PrimaryLockerRobot with lockerP and SuperLockerRobot with LockerS
   * And all the lockers have available spaces
   * When normal cusomter stores a s bag
   * Then store successfully
   * And get valid ticket
   * And bagA is stored in LockerA

   * Given XiaoYing manages LockerA, PrimaryLockerRobot with lockerP and SuperLockerRobot with LockerS
   * And all the lockers have available spaces
   * When normal cusomter stores a M bag
   * Then store successfully
   * And get valid ticket
   * And bag is stored in LockerB

   * Given XiaoYing manages LockerA, PrimaryLockerRobot with lockerP and SuperLockerRobot with LockerS
   * And all the lockers have available spaces
   * When normal cusomter stores a L bag
   * Then store successfully
   * And get valid ticket
   * And bag is stored in LockerC

   * Given XiaoYing manages full LockerA, PrimaryLockerRobot with lockerP and SuperLockerRobot with LockerS
   * PrimaryLockerRobot and SuperLockerRobot have available spaces
   * When normal cusomter stores a s bag
   * Then store failed
   * And get <No available space> error

   * Given XiaoYing manages full LockerA and available lockerB, PrimaryLockerRobot with lockerP and SuperLockerRobot with LockerS
   * PrimaryLockerRobot and SuperLockerRobot have available spaces
   * When normal customter stores a S bag
   * Then store successfully
   * And get valid ticket
   * And bag is stored in LockerB

  * Given XiaoYing manages LockerA, PrimaryLockerRobot with available lockerP1 and available LockerP2 and SuperLockerRobot with available LockerS
  * When normal cusomter stores a M bag
  * Then store successfully
  * And get valid ticket
  * And bag is stored in LockerP1

  * Given XiaoYing manages LockerA, PrimaryLockerRobot with full lockerP1 and available LockerP2 and SuperLockerRobot with available LockerS
  * When normal cusomter stores a M bag
  * Then store successfully
  * And get valid ticket
  * And bag is stored in LockerP2

  * Given XiaoYing manages LockerA, PrimaryLockerRobot with available lockerP and SuperLockerRobot with available LockerS1(2/10) and available LockerS2(1/10)
  * When normal cusomter stores a L bag
  * Then store successfully
  * And get valid ticket
  * And bag is stored in LockerS2

  * Given XiaoYing manages LockerA, PrimaryLockerRobot with available lockerP and SuperLockerRobot with available LockerS1(2/10) and available LockerS2(2/10)
  * When normal cusomter stores a L bag
  * Then store successfully
  * And get valid ticket
  * And bag is stored in LockerS1

```
# 取包

```
   * Given XiaoYing manages lockerA and PrimaryLockerRobot and SuperLockerRobot , Xiaoying stored S bag success to lockerA and get TicketA
   * When get bag with ticketA
   * Then get bagA successfully

   * Given XiaoYing manages lockerA and PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS , XiaoYing stored M bag success to lockerP and get TicketA
   * When get bag with ticketA
   * Then get bagA successfully

   * Given XiaoYing manages lockerA and PrimaryLockerRobot with LockerP1 and LockerP2 and SuperLockerRobot with LockerS , XiaoYing stored M bag success to lockerP1 and get TicketA
   * When get bag with ticketA
   * Then get bag successfully

   * Given XiaoYing manages lockerA and PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS , XiaoYing stored M bag success to lockerP and get TicketA
   * When XiaYing gets bag with fake ticket
   * Then get '<Invalid ticket>' error 

   * Given XiaoYing manages lockerA and PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS , XiaoYing stored L bag success to lockerS and get TicketA
   * When get bag with ticketA
   * Then get bagA successfully

   * Given XiaoYing manages lockerA and PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS1 and LockerS2 , XiaoYing stored L bag success to lockerS2 and get TicketA
   * When get bag with ticketA
   * Then get bagA successfully

   * Given XiaoYing manages lockerA and PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS1 and LockerS2 , XiaoYing stored L bag success to lockerS2 and get TicketA
   * When XiaYing gets bag with fake ticket
   * Then get '<Invalid ticket>' error 


```
