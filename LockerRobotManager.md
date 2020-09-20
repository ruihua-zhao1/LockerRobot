 ## Tasking
 # 存包
```
   * Given LockerRobotManager manage LockerA, PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS
   * And all the lockers has available spaces
   * When VIP customer store S bag
   * Then store successfully
   * And get valid ticket
   * And bagA is stored in LockerA

   * Given LockerRobotManager manage full LockerA, PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS
   * When VIP customer store S bag
   * Then store failed
   * And get <No available space> error

   * Given LockerRobotManager manage LockerA, PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS
   * And all the lockers has available spaces
   * When VIP customer stores M bag
   * Then store successfully
   * And get valid ticket
   * And bag is stored in LockerP

   * Given LockerRobotManager manage available LockerA, PrimaryLockerRobot with full LockerP and SuperLockerRobot with LockerS
   * When VIP customer store M bag
   * Then store failed
   * And get <No available space> error

   * Given LockerRobotManager manage LockerA, PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS
   * And all the lockers has available spaces
   * When VIP customer stores L bag
   * Then store successfully
   * And get valid ticket
   * And bag is stored in LockerS

   * Given LockerRobotManager manage available LockerA, PrimaryLockerRobot with available LockerP and SuperLockerRobot with full LockerS
   * When VIP customer store L bag
   * Then store failed
   * And get <No available space> error

```

 # 取包

```

   * Given LockerRobotManager manage LockerA, PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS
   * And VIP customer stored a S bag and get valid ticket
   * When VIP customer get bag with valid ticket
   * Then get bag successfully

   * Given LockerRobotManager manage LockerA, PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS
   * And VIP customer stored a M bag and get valid ticket
   * When VIP customer get bag with valid ticket
   * Then get bag successfully

   * Given LockerRobotManager manage LockerA, PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS
   * And VIP customer stored a L bag and get valid ticket
   * When VIP customer get bag with valid ticket
   * Then get bag successfully

   * Given LockerRobotManager manage LockerA, PrimaryLockerRobot with LockerP and SuperLockerRobot with LockerS
   * And VIP customer stored a L bag and get valid ticket
   * When get bag with fake ticket
   * Then get '<Invalid ticket>' error 

   * Given LockerRobotManager manage LockerA, SuperLockerRobot with LockerS
   * And VIP customer stored a S bag and get valid ticket
   * When get bag with fake ticket
   * Then get '<Invalid ticket>' error 

```