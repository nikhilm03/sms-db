# sms-db
Stock Management System

The spring boot application (entry point  - StockManipulationSystem.java) loads following beans in classpath : 

1. HazelcastConfig.java : creates hz node.
2. TradeInsertUtility.java : inserts test trades for the application with manipulative trader (nikhil.mayaskar@db.com) and a good trader (good.trader@db.com).
3. SmsJob.java : a cron job that runs every 2 mins and submits a distributed job.
4. TradeManipulationTask.java : An api that runs on hz nodes and flags the trader who breaches the contract. This is reported back to SmsJob which informs regulatory authorities about the breach.
5. RegulatoryAuthority.java : receives breach details via rest end-point.
